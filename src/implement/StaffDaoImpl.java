package implement;

import dao.StaffDao;
import model.Staff;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDaoImpl extends DataBaseConnection implements StaffDao {
    /**
     * 登录验证
     *
     * @param staffId
     * @return 当前员工数据
     * @throws Exception
     */
    @Override
    public Staff verifyLogin(String staffId,String password) throws Exception {
        Staff staff = null;
        Connection conn = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM staff where binary staffId=? and binary password=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staffId);
        pstmt.setString(2, password);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            staff = new Staff();
            staff.setStaffId(result.getString(1).trim());
            staff.setPassword(result.getString(2).trim());
            staff.setFullName(result.getString(3).trim());
            staff.setAvgScore(result.getDouble(4));
            staff.setOrderSum(result.getInt(5));
            staff.setStationId(result.getString(6).trim());
            staff.setIsAble(result.getInt(6));

        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        return staff;
    }

    /**
     * 查询某一员工数据
     *
     * @param staffId
     * @return
     * @throws Exception
     */
    @Override
    public Staff getStaffByStaffId(String staffId,String stationId) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM staff where staffId=? and stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staffId);
        pstmt.setString(2, stationId);
        ResultSet result = pstmt.executeQuery();
        Staff staff = null;
        while (result.next()) {
            staff = new Staff();
            staff.setStaffId(result.getString(1));
            staff.setPassword(result.getString(2));
            staff.setFullName(result.getString(3));
            staff.setAvgScore(result.getDouble(4));
            staff.setOrderSum(result.getInt(5));
            staff.setStationId(result.getString(6));
            staff.setIsAble(result.getInt(7));
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        return staff;
    }
}
