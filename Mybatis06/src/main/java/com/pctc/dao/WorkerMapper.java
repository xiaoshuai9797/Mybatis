package com.pctc.dao;

import com.pctc.model.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerMapper {
    /**
     * 根据ID查找信息，测试一级缓存
     * @param id
     * @return
     */
    public Worker getWorkerByid(Integer id);

    /**测试一级缓存
     *
     * @param worker
     * @return
     */
    public List<Worker> getWorker(Worker worker);


    /**
     * 增加工人
     * @param worker
     * @return
     */
    public int insertWorker(Worker worker);
}
