package implement;

import dao.BaseDao;
import dao.missionDao;
import model.mission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class missionImpl implements missionDao {

    public ArrayList<mission> search() throws Exception {
        ArrayList<mission> list = new ArrayList<mission>();
        String sql = "select * from record";
        PreparedStatement stmt = null;
        Connection conn = BaseDao.getConnection();
        stmt = conn.prepareStatement(sql);
        ResultSet rs = null;
        rs = stmt.executeQuery();
            while (rs.next()) {
                    mission tem = new mission();
                    tem.setOrderId(rs.getString("orderId"));
                    tem.setIdcard(rs.getString("idcard"));
                    tem.setFullname(rs.getString("fullname"));
                    tem.setCarId(rs.getString("carId"));
                    tem.setAddress(rs.getString("address"));
                    tem.setOrderTime(rs.getString("orderTime"));
                    tem.setCheckTime(rs.getString("checkTime"));
                    tem.setResult(rs.getString("result"));
                    tem.setStaffname(rs.getString("staffname"));
                    tem.setStaffId(rs.getString("staffId"));
                    tem.setScore(rs.getInt("score"));
                    tem.setProcess(rs.getString("process"));
                    tem.setAvailable(rs.getBoolean("available"));
                    list.add(tem);
                }
        return list;
    }
}



