package dao;

import model.Staff;

import java.util.ArrayList;

public interface StaffDao {
    /**
     * 登录验证
     *
     * @param staffId
     * @return 当前员工数据
     * @throws Exception
     */
    Staff verifyLogin(String staffId, String password) throws Exception;

    /**
     * 查询某一员工数据
     *
     * @param staffId
     * @return 返回指定编号员工数据
     * @throws Exception
     */
    Staff getStaffByStaffId(String staffId, String stationId) throws Exception;

    /**
     * 查询对应检测站员工姓名
     *
     * @param stationId
     * @return 指定检测站员工姓名列表
     * @throws Exception
     */
    ArrayList<Staff> getStaffListByStationId(String stationId) throws Exception;
}
