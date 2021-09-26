package com.pctc.dao;

import com.pctc.model.Worker;

import java.util.List;
import java.util.Map;

public interface WorkerMapper {


    /**
     * 使用分页插件
     * @param worker
     * @return
     */
    public List<Worker> selectWorkerPagePlug(Worker worker);


    public List<Worker> selectWorkerPage(Map<String,Object> map);

}
