package implement;

import dao.BaseDao;
import dao.staffinfoDao;
import model.staffinfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class staffInfoImpl implements staffinfoDao {

    public ArrayList<staffinfo> search() throws Exception {
        ArrayList<staffinfo> list=new ArrayList<staffinfo>();
        String sql = "select * from staff";
        PreparedStatement stmt = null;
        try {
            Connection conn = BaseDao.getConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                staffinfo tem = new staffinfo();
                tem.setStaffId(rs.getString("staffId"));
                tem.setStaffname(rs.getString("fullname"));
                tem.setAvgScore(rs.getDouble("avgScore"));
                tem.setOrderSum(rs.getInt("orderSum"));
                tem.setStationId(rs.getString("stationId"));
                tem.setIsAble(rs.getInt("isAble"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(String staffid,String staffname,String stationid,Boolean isable) throws Exception {
        try {
            String sql = "insert into staff values (?,?,?,?,?,?)";
            PreparedStatement stmt = null;
            Connection conn = BaseDao.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,staffid);
            stmt.setString(2,staffname);
            stmt.setDouble(3,0);
            stmt.setInt(4,0);
            stmt.setString(5,stationid);
            stmt.setBoolean(6,isable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(){
        try {
            String sql = "upadte staff set staffId=? staffname=? avgScore=? orderSum=? stationId=? isAble=?";
            PreparedStatement stmt = null;
            Connection conn = null;
            conn = BaseDao.getConnection();
            stmt = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}