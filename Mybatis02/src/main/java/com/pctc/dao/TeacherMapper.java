package com.pctc.dao;

import com.pctc.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {

    //下面的代码使用注解的方式。不需要TeacherMapper.xml文件

    /**
     * 使用注解的方式查询所有信息
     * @return
     */
    // @Select("select t_name as name,t_age as age,t_protitle as protitle from teacher")如果类属性名和数据库字段名不一样，则采用此方法
    @Select("select * from teacher")//如果数据库字段名和类属性名一样，则此方法即可
    @ResultType(Teacher.class)//写不写无所谓
    public List<Teacher> getAllMessage();

    /**
     * 增加
     * @param teacher
     * @return
     */
    @Insert("insert into teacher(name,age,protitle) values(#{name},#{age},#{protitle})")
    @ResultType(int.class)//可写可不写
    public int insertTeacher(Teacher teacher);


    /**
     * 根据ID删除相对应的信息
     * @param id
     * @return
     */
    @Delete("delete from teacher where id=#{id}")
    @ResultType(int.class)//可写可不写
    public int deleteTeacher(Integer id);


    /**
     * 根据ID修改信息
     * @param teacher
     * @return
     */
    @Update("update teacher set name=#{name},age=#{age},protitle=#{protitle} where id=#{id}")
    public int editTeacher(Teacher teacher);


    /**
     * 根据ID查找信息
     * @param id
     * @return
     */
    @Select("select name,age,protitle from teacher where id=#{id}")
    public Teacher getMessageById(int id);

    /**
     * ID大于多少的信息输出出来
     * @param id
     * @return
     */
    @Select("select * from teacher where id>#{id}")//上面的方法写出了每个字段名，这里用*试试
    public List<Teacher> getMessageById1(int id);

    /**
     * 根据ID大于多少并且姓名是什么查找信息
     * @param id
     * @param name
     * @return
     */
    @Select("select * from teacher where id>#{param1} and name like #{param2}")
    public List<Teacher> getMessageByIdName(int id, String name);


    /**
     * 根据ID和Name查找数据并把数据封装在Map中
     * @param map
     * @return
     */
    @Select("select * from teacher where id>#{param1} and name=#{param2}")
    public List<Teacher> getMessageByIdName1(Map<String,Object>map);


    /**
     *
     * @param id
     * @param name
     * @return
     */
    @Select("select * from teacher where id>#{param1} and name=#{param2}")
    public List<Teacher> getMessageByIdName2(@Param("id")Integer id, @Param("name")String name);


}
