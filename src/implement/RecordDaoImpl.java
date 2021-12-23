package implement;

import dao.RecordDao;
import model.Record;
import utils.DataBaseConnection;
import utils.DateTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecordDaoImpl extends DataBaseConnection implements RecordDao {
    /**
     * 查询检测员所有检测数据
     *
     * @return 检测数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<Record> getRecordList(String stationId,String staffId) throws Exception {
        ArrayList<Record> recordList = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "SELECT record.* FROM record,station where stationId=? and staffId=? and station.address = record.address";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);
        pstmt.setString(2, staffId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {

            Record record = new Record();
            record.setOrderId(result.getString(1).trim());
            record.setIdCard(result.getString(2).trim());
            record.setFullName(result.getString(3).trim());
            record.setCarId(result.getString(4).trim());
            record.setAddress(result.getString(5).trim());
            record.setOrderTime(result.getString(6).trim());
            String checkTime = "待定";
            if (result.getString(7) != null) {
                checkTime = result.getString(7);
            }
            record.setCheckTime(checkTime);
            String re = "待定";
            if (result.getString(8) != null) {
                re = result.getString(8);
            }
            record.setResult(re);
            String staffName = "待定";
            if (result.getString(9) != null) {
                staffName = result.getString(9);
            }
            record.setStaffName(staffName);
            String staffId2 = "待定";
            if (result.getString(10) != null) {
                staffId2 = result.getString(10);
            }
            record.setStaffId(staffId2);
            record.setScore(result.getInt(11));
            record.setProcess(result.getString(12).trim());
            record.setAvailable(result.getInt(13));
            recordList.add(record);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!recordList.isEmpty()) {
            return recordList;
        } else {
            return new ArrayList<>();
        }
    }


    /**
     * 根据 orderId 分配任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    @Override
    public Boolean uploadDetectionResult(Record record) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update record set result=?,process=?,available=? where orderId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, record.getResult());
        pstmt.setString(2, record.getProcess());
        pstmt.setInt(3, record.getAvailable());
        pstmt.setString(4, record.getOrderId());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
