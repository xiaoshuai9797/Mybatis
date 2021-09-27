package com.pctc.dao;

import com.pctc.model.Factory;
import com.pctc.model.FactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryMapper {
    int countByExample(FactoryExample example);

    int deleteByExample(FactoryExample example);

    int deleteByPrimaryKey(Integer tId);

    int insert(Factory record);

    int insertSelective(Factory record);

    List<Factory> selectByExample(FactoryExample example);

    Factory selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") Factory record, @Param("example") FactoryExample example);

    int updateByExample(@Param("record") Factory record, @Param("example") FactoryExample example);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
}