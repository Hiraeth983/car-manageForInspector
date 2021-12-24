package implement;

import dao.ApplicationDao;
import model.Application;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ApplicationDaoImpl extends DataBaseConnection implements ApplicationDao {

    /**
     * 获取某一站点申请调度信息列表
     *
     * @param stationId
     * @return 返回申请调度信息列表
     * @throws Exception
     */
    @Override
    public ArrayList<Application> getApplicationListByStationId(String stationId) throws Exception {
        ArrayList<Application> applications = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "select application.orderId,application.submitTime,oStaff.oStaffId,oStaff.fullName,nStaff.nStaffId,nStaff.fullName,reason,state\n" +
                "from application,\n" +
                "\t(select application.orderId,application.oStaffId,staff.fullName,staff.stationId\n" +
                "\t\t\tfrom application,staff where application.oStaffId = staff.staffId) as oStaff,\n" +
                "\t(select application.orderId,application.nStaffId,staff.fullName \n" +
                "\t\t\tfrom application,staff where application.nStaffId = staff.staffId) as nStaff\n" +
                "where \n" +
                "\tapplication.orderId = oStaff.orderId and oStaff.orderId = nStaff.orderId and oStaff.stationId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Application application = new Application();
            application.setOrderId(result.getString(1).trim());
            application.setSubmitTime(result.getString(2).trim());
            application.setoStaffId(result.getString(3).trim());
            application.setoStaffName(result.getString(4).trim());
            application.setnStaffId(result.getString(5).trim());
            application.setnStaffName(result.getString(6).trim());
            application.setReason(result.getString(7).trim());
            application.setState(result.getString(8).trim());

            applications.add(application);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!applications.isEmpty()) {
            return applications;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 审核申请（修改处理状态）
     *
     * @param app
     * @return 修改是否成功
     * @throws Exception
     */
    @Override
    public Boolean examineApplication(Application app) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update application set state=? where orderId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, app.getState());
        pstmt.setString(2, app.getOrderId());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 插入一条申请任务调换信息
     *
     * @param application
     * @return 插入是否成功
     * @throws Exception
     */
    @Override
    public Boolean insertApplication(Application application) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "insert into application values(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, application.getOrderId());
        pstmt.setString(2, application.getSubmitTime());
        pstmt.setString(3, application.getoStaffId());
        pstmt.setString(4, application.getnStaffId());
        pstmt.setString(5, application.getReason());
        pstmt.setString(6, "已申请");

        boolean flag = pstmt.execute();
        conn.close();
        pstmt.close();
        return flag;
    }

    public Boolean examineApplicationWithState(Application app) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update record set staffId=?,staffName=? where orderId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, app.getnStaffId());
        pstmt.setString(2, app.getnStaffName());
        pstmt.setString(3, app.getOrderId());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    public ArrayList<Application> getApplicationListByStaffId(String staffId) throws Exception {
        ArrayList<Application> applications = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "select application.orderId,application.submitTime,oStaff.oStaffId,oStaff.fullName,nStaff.nStaffId,nStaff.fullName,reason,state\n" +
                "from application,\n" +
                "\t(select application.orderId,application.oStaffId,staff.fullName,staff.stationId\n" +
                "\t\t\tfrom application,staff where application.oStaffId = staff.staffId) as oStaff,\n" +
                "\t(select application.orderId,application.nStaffId,staff.fullName \n" +
                "\t\t\tfrom application,staff where application.nStaffId = staff.staffId) as nStaff\n" +
                "where \n" +
                "\tapplication.orderId = oStaff.orderId and oStaff.orderId = nStaff.orderId and oStaff.oStaffId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staffId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Application application = new Application();
            application.setOrderId(result.getString(1).trim());
            application.setSubmitTime(result.getString(2).trim());
            application.setoStaffId(result.getString(3).trim());
            application.setoStaffName(result.getString(4).trim());
            application.setnStaffId(result.getString(5).trim());
            application.setnStaffName(result.getString(6).trim());
            application.setReason(result.getString(7).trim());
            application.setState(result.getString(8).trim());

            applications.add(application);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!applications.isEmpty()) {
            return applications;
        } else {
            return new ArrayList<>();
        }
    }

    public Boolean deleteApplicationByOrderId(String orderId) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "delete from application where orderId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, orderId);

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    public Boolean updateApplicationByOrderId(Application application) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update application set reason=?,oStaffId=?,oStaffName=? where orderId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, application.getReason());
        pstmt.setString(2, application.getnStaffId());
        pstmt.setString(3,application.getnStaffName());
        pstmt.setString(4,application.getOrderId());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
