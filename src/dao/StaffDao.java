package dao;

import model.Staff;

public interface StaffDao {
    /**
     * 登录验证
     *
     * @param staffId
     * @return 当前员工数据
     * @throws Exception
     */
    Staff verifyLogin(String staffId,String password) throws Exception;

    /**
     * 查询某一员工数据
     *
     * @param staffId
     * @return 返回指定编号员工数据
     * @throws Exception
     */
    Staff getStaffByStaffId(String staffId,String stationId) throws Exception;
}
