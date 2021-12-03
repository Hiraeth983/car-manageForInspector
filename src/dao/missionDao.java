package dao;

import model.mission;
import java.util.ArrayList;

public interface missionDao extends BaseDao {
    public ArrayList<mission> search() throws Exception;//查询任务信息
}
