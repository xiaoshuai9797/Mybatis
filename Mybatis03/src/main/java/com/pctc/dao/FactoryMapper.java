package com.pctc.dao;

import com.pctc.model.Factory;
import com.pctc.model.WorkerFactoryVo;

import java.util.List;

public interface FactoryMapper {

    /**
     * 根据ID找工厂
     * @param id
     * @return
     */
    public Factory getFactoryById(Integer id);

    /**
     * 根据工人的id查询工人，包括工人所在的工厂，连接查询
     * @param id
     * @return
     */
    public Factory getFactoryById1(Integer id);

    /**
     *根据工人的id查询工人，包括工人所在的工厂，嵌套查询
     * 上面是连接查询，嵌套查询可使用懒/延迟查找。
     * @param id
     * @return
     */
    public Factory getFactoryById2(Integer id);


    public List<WorkerFactoryVo> getFactoryIdVo(Integer id);
}
