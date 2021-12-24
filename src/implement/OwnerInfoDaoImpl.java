package implement;

import dao.OwnerInfoDao;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OwnerInfoDaoImpl extends DataBaseConnection implements OwnerInfoDao {
    /**
     * 修改对应车主申请状态信息
     *
     * @param idCard
     * @return
     * @throws Exception
     */
    @Override
    public Boolean updateOwnerInfoByIdCard(String idCard) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update ownerInfo set orderId='0' where idCard=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, idCard);

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
