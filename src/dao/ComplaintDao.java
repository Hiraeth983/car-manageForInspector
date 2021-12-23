package dao;

import model.Complaint;

import java.util.ArrayList;

public interface ComplaintDao {
    /**
     * 返回投诉指定员工数据
     * @param staffId
     * @return 投诉指定员工数据列表
     * @throws Exception
     */
    ArrayList<Complaint> getComplaintListByStaffId(String staffId) throws Exception;

}
