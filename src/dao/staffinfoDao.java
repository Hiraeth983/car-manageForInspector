package dao;

import implement.staffinfoImpl;
import model.staffinfo;

import java.util.ArrayList;

public interface staffinfoDao extends BaseDao {
        public ArrayList<staffinfo> search() throws staffinfoImpl.DaoException, Exception;//显示信息
        public void insert() throws staffinfoImpl.DaoException, staffinfoImpl.DaoException, staffinfoImpl.DaoException;//插入信息
        public void update() throws staffinfoImpl.DaoException, staffinfoImpl.DaoException, staffinfoImpl.DaoException;//更新信息
}
