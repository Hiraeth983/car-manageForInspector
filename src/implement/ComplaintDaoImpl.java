package implement;

import dao.ComplaintDao;
import model.Complaint;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComplaintDaoImpl extends DataBaseConnection implements ComplaintDao {
    /**
     * 返回投诉指定员工数据
     * @param staffId
     * @return 投诉指定员工数据列表
     * @throws Exception
     */
    @Override
    public ArrayList<Complaint> getComplaintListByStaffId(String staffId) throws Exception {
        ArrayList<Complaint> complaints = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "select complaint.* from complaint,staff where complaint.staffId=staff.staffId and staff.staffId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,staffId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Complaint complaint = new Complaint();
            complaint.setOrderId(result.getString(1).trim());
            complaint.setSubmitTime(result.getString(2).trim());
            complaint.setStaffId(result.getString(3).trim());
            complaint.setComplaintDescribe(result.getString(4).trim());
            complaint.setResult(result.getString(5).trim());

            complaints.add(complaint);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!complaints.isEmpty()) {
            return complaints;
        } else {
            return new ArrayList<>();
        }
    }
}
