package com.pctc.dao;

import com.pctc.model.Worker;
import com.pctc.model.WorkerFactoryVo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface WorkerMapper {


    /**
     * 根据ID查找工人，并且找出工人所在的工厂
     * 配合FactoryMapper中的getFactoryById方法配合使用，查找所有信息。
     * @param id
     * @return
     */
    @Select("select * from worker where t_id=#{id}")//根据ID查出这个工人的所有信息
    @Results(
            {
                    @Result(property = "id",column = "t_id"),
                    @Result(property = "name",column = "t_name"),
                    @Result(property = "age",column = "t_age"),
                    @Result(property = "birthday",column = "t_birthday"),
                    @Result(property = "fid",column = "t_fid"),
                    @Result(property = "factory",column = "t_fid",one=@One(select = "com.pctc.dao.FactoryMapper.getFactoryById",fetchType = FetchType.LAZY))
                    //property是类对象，column是当前表中关联字段名t_fid和下一个方法有所不同
            }
    )
    public Worker getWorkerById(Integer id);

    /**
     * 和FactoyrMapper中的getFactoryById1配合使用查找所有信息
     * @param id
     * @return
     */
    @Select("select * from worker where t_fid=#{id}")
    @Results({
            @Result(property = "id",column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthday",column = "t_birthday"),
            @Result(property = "fid",column = "t_fid"),
    })
    public List<Worker> getWorkerByFactoryId(Integer id);


    /**
     * 根据VO类查找所有信息
     * @param id
     * @return
     */
    @Select("select w.*,f.t_factoryname as t_factoryName from worker w,factory f where w.t_fid=f.t_id and w.t_id=#{id}")
    @Results({
            @Result(property = "id",column = "t_id"),
            @Result(property = "name",column = "t_name"),
            @Result(property = "age",column = "t_age"),
            @Result(property = "birthday",column = "t_birthday"),
            @Result(property = "fid",column = "t_fid"),

            @Result(property = "factoryName",column = "t_factoryName")
    })
    public WorkerFactoryVo  getWorkerByIdVo(Integer id);


}
