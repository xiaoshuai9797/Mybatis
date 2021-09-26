package com.pctc.dao;

import com.pctc.model.Worker;
import com.pctc.model.WorkerFactoryVo;

import java.util.List;

public interface WorkerMapper {

    /**
     * 通过ID找出工人的信息
     * @param id
     * @return
     */
    public Worker getWorkerById(Integer id);


    /**
     * 根据工人的id查询工人，包括工人所在的工厂， association
     * @param id
     * @return
     */
    public Worker getWorkerById1(Integer id);



    /**
     * 根据工人的id查询工人，包括工人所在的工厂， association,使用嵌套查询方法。
     * 上面是连接查询，嵌套查询可使用懒/延迟查找。
     *
     * @param id
     * @return
     */
    public Worker getWorkerById2(Integer id);



    /**
     * 根据工人所在的工厂id查询在此工厂的工人
     * 配合FactoryMapper中的getFactoryById2一起使用
     * @param fid
     * @return
     */
    public List<Worker> getWorkersByFactoryId(Integer fid);

    public WorkerFactoryVo getWorkerIdVo(Integer id);
}
