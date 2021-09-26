package com.pctc.dao;

import com.pctc.model.Factory;


public interface FactoryMapper {
    /**
     * 根据ID查找工厂，通过第三方二级缓存可查出工人信息
     * @param id
     * @return
     */
    public Factory getFactoryId(Integer id);
}
