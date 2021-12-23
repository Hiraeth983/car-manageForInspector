package dao;

import model.Record;

import java.util.ArrayList;

public interface RecordDao {

    /**
     * 查询所有检测数据
     *
     * @return 检测数据数组
     * @throws Exception
     */
    ArrayList<Record> getRecordList(String stationId,String staffId) throws Exception;



    /**
     * 根据 orderId 分配任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    Boolean uploadDetectionResult(Record record) throws Exception;



}
