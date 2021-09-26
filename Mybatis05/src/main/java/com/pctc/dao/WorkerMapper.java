package com.pctc.dao;

import com.pctc.model.Worker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerMapper {

    /**
     * 测试IF标签
     * @param worker
     * @return
     */
    public List<Worker> getWorker(Worker worker);

    /**
     * 测试Where标签
     * @param worker
     * @return
     */
    public List<Worker> getWorker1(Worker worker);

    /**
     * 测试choose标签
     * @param worker
     * @return
     */
    public List<Worker> getWorker2(Worker worker);

    /**
     * 测试where和choose标签的配合
     * @param worker
     * @return
     */
    public List<Worker> getWorker3(Worker worker);

    /**
     * 测试Set标签
     * @param worker
     * @return
     */
    public int updateWorker(Worker worker);

    /**
     * 测试trim标签里面的prefix
     * @param worker
     * @return
     */
    public List<Worker> getWorker4(Worker worker);

    /**
     * 测试trim标签里面的suffix
     * @param worker
     * @return
     */
    public List<Worker> getWorker5(Worker worker);

    /**
     * 测试foreach标签
     * @param list
     * @return
     */
    //public List<Worker> getWorker6(@Param("list")List<Worker>list);注解方式
    public List<Worker> getWorker6(List<Integer> list);

    /**
     * foreach标签批量增加数据
     * @param list
     * @return
     */
    //public int addWorkerBatch(List<Integer> list);正常方法
    public int addWorkerBatch(@Param("list")List<Worker>list);

    /**
     * sql和include标签
     * @param list
     * @return
     */
    public int addWorkerBatch1(List<Worker> list);


    /**
     * 测试bind标签
     * @param worker
     * @return
     */
    public List<Worker> getWorker7(Worker worker);




}
