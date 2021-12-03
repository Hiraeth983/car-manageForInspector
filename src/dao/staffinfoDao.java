package dao;

import model.staffinfo;
import java.util.ArrayList;

public interface staffinfoDao extends BaseDao {
        public ArrayList<staffinfo> search() throws Exception;//显示信息
        public void insert(String staffid,String staffname,String stationid,Boolean isable) throws Exception;//插入信息
        public void update();//更新信息
}
