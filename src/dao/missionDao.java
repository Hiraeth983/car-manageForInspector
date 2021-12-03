package dao;

import implement.missionImpl;
import model.mission;
import java.util.ArrayList;

public interface missionDao extends BaseDao {
    public ArrayList<mission> search() throws missionImpl.DaoException, Exception;//查询任务信息
}
