package com.pctc.dao;

import com.pctc.model.Factory;
import com.pctc.model.Worker;
import com.pctc.model.WorkerFactoryVo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface FactoryMapper {
    /**
     * 根据ID查找工厂，不查找工人信息。
     * 配合WorkerMapper中的getWorkerById方法查找所有信息
     * @param id
     * @return
     */
    @Select("select * from factory where t_id=#{id}")
    @Results({
            @Result(property = "id",column = "t_id"),
            @Result(property = "factoryName",column = "t_factoryName")
    })
    public Factory getFactoryById(Integer id);


    /**
     * 和WorkerMapper中的getWorkerByFactoryId配合使用
     * @param id
     * @return
     */
    @Select("select * from factory where t_id=#{id}")
    @Results({
            @Result(property = "id",column = "t_id"),
            @Result(property = "factoryName",column = "t_factoryName"),
            @Result(property = "workers",column = "t_id",many=@Many(select="com.pctc.dao.WorkerMapper.getWorkerByFactoryId",fetchType = FetchType.LAZY))
            //property是工人集合，而不是worker，column是当前表的主键字段名，和上一个方法对比，property和column的值意义不一样
    })
    public Factory getFactoryById1(Integer id);

    /**
     * 使用VO类来查找所有信息
     * @param id
     * @return
     */
    @Select("select w.*,f.t_factoryname as t_factoryName from worker w,factory f where w.t_fid=f.t_id and f.t_id=#{id}")
    @Results({
            @Result(property = "id",column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthday",column = "t_birthday"),
            @Result(property = "fid",column = "t_fid"),

            @Result(property = "factoryName",column = "t_factoryName")
    })
    public  List<WorkerFactoryVo> getFactoryByIdVo(Integer id);


}
