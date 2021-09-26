package com.pctc.dao;

import com.pctc.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    public List<Teacher> getAllMessage();//统计
    public int insertTeacher(Teacher teacher);//增
    public int editTeacher(Teacher teacher);//改
    public int deleteTeacher(Integer id);//删


    /**
     * 既有对象又带参数类型，见TeacherMapper.xml中具体代码
     * @param teacher
     * @return
     */
    public int insertTeacher1(Teacher teacher);

    /**
     * 封装成map，直接传数据
     * @param map
     * @return
     */
    public int insertTeacher2(Map<String ,Object> map);


    /**
     * 任意多个参数，都会被MyBatis重新包装成一个Map传入。Map的key是param1，param2，param3或者0，1，2,值就是参数的值。
     * @param name
     * @param age
     * @param protitle
     * @return
     */
    public int insertTeacher3(String name,Integer age,String protitle);


    /**
     * 查询用户，并且返回的是resultMap
     * @return
     */
    public List<Teacher> getAllMessage1();







}
