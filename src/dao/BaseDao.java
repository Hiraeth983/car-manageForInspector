package dao;
import implement.staffinfoImpl;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

//根接口
public interface BaseDao {
    // 查找并返回数据源对象
    public static DataSource getDataSource(){
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();//初始化资源
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/webstoreDS");

        }catch(NamingException ne){
            System.out.println("Exception:"+ne);
        }
        return dataSource;
    }
    // 返回一个连接对象
    public static Connection getConnection() throws staffinfoImpl.DaoException {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        try{
            conn =  dataSource.getConnection();
        }catch(SQLException sqle){
            System.out.println("Exception:"+sqle);
        }
        return  conn;
    }
}
