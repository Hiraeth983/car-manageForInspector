package implement;

import dao.BaseDao;
import dao.staffinfoDao;
import model.staffinfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class staffinfoImpl implements staffinfoDao {

    public ArrayList<staffinfo> search() throws DaoException, SQLException {
        ArrayList<staffinfo> list=new ArrayList<staffinfo>();
        String sql = "select * from staff";
        PreparedStatement stmt = null;
        try {
            Connection conn = BaseDao.getConnection();
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            try {
                staffinfo tem = new staffinfo();
                tem.setStaffId(rs.getString("staffId"));
                tem.setStaffname(rs.getString("staffname"));
                tem.setAvgScore(rs.getDouble("avgScore"));
                tem.setOrderSum(rs.getInt("orderSum"));
                tem.setStationId(rs.getString("stationId"));
                tem.setIsAble(rs.getBoolean("isAble"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    @Override
    public void insert() throws DaoException {
        String sql = "insert into staff values (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            Connection conn = BaseDao.getConnection();
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() throws DaoException {
        String sql = "upadte staff set staffId=? staffname=? avgScore=? orderSum=? stationId=? isAble=?";
        PreparedStatement stmt = null;
        try {
            Connection conn = BaseDao.getConnection();
            stmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public class DaoException extends Exception {
    }
}