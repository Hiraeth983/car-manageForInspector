package dao;

public interface OwnerInfoDao {

    /**
     * 修改对应车主申请状态信息
     * @param idCard
     * @return
     * @throws Exception
     */
    Boolean updateOwnerInfoByIdCard(String idCard) throws Exception;
}
