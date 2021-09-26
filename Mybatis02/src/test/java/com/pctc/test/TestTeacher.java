package com.pctc.test;

import com.pctc.dao.TeacherMapper;
import com.pctc.model.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTeacher {

    private SqlSession session;



//	1）、将sql映射文件注册在全局配置文件中。
//	2）、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象  有数据源一些运行环境信息
//	3）、使用SqlSessionFactory，获取到sqlSession对象使用他来执行增删改查，一个sqlSession就是代表和数据库的一次会话，用完关闭。
//	4）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。

    @Before
    public void read() throws Exception {
        // 构建mybatis的执行对象
//		FileInputStream fis = new FileInputStream("src/config.xml");
//		SqlSession session = new SqlSessionFactoryBuilder().build(fis)
//				.openSession();

        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        this.session = session;
    }


    @Test
    public void testGetAllMessage(){

        System.out.println("查询所有用户");
        //获取接口的实现类对象
        //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
        try {

            TeacherMapper mapper=session.getMapper(TeacherMapper.class);

            List<Teacher> teachers=mapper.getAllMessage();
            System.out.println(teachers);
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void testInsertTeacher(){
        System.out.println("添加用户");
        //获取接口的实现类对象
        //会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
        try {
            TeacherMapper mapper=session.getMapper(TeacherMapper.class);
            //System.out.println(mapper);
            Teacher teacher = new Teacher("胡杰",20,"初级教师");
            int count=mapper.insertTeacher(teacher);
            session.commit();
            System.out.println(count);
        } finally {
            session.close();
        }
    }


    @Test
    public void TestDeleteTeacher() {
        System.out.println("删除用户");
        try {
            TeacherMapper mapper=session.getMapper(TeacherMapper.class);
            // System.out.println(mapper);
            int count=mapper.deleteTeacher(14);// 根据字符找sql语句
            session.commit();
            //session.rollback();
            System.out.println(count);
        } finally {
            session.close();
        }

    }


    @Test
    public void testEditTeacher(){

        System.out.println("修改用户");
        TeacherMapper mapper=session.getMapper(TeacherMapper.class);
        Teacher teacher=new Teacher(15,"汪炳剑",30,"特级教师");
        int count=mapper.editTeacher(teacher);// 根据字符找sql语句
        session.commit();
        //session.rollback();
        System.out.println(count);
    }


    @Test
    public void testGetMessageById(){
        System.out.println("根据ID查找出来的信息如下");
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getMessageById(1);
        System.out.println(teacher);
        session.commit();

    }


    @Test
    public void testGetMessageById1(){
        System.out.println("根据ID查找出来的信息如下");
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers=mapper.getMessageById1(15);
        for(Teacher T:teachers){
            System.out.println(T);
        }
        session.commit();
    }


    @Test
    public void testGetMessageByIdName(){
        System.out.println("查找出来的信息如下");
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers=mapper.getMessageByIdName(3,"%刘%");
        for(Teacher T:teachers){
            System.out.println(T);
        }
        session.commit();
    }


    @Test
    public void testGetMessageByIdName1(){
        System.out.println("查找出来的信息如下");
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("param1",3);
        map.put("param2","胡杰");
        List<Teacher> teachers=mapper.getMessageByIdName1(map);
        for(Teacher T:teachers){
            System.out.println(T);
        }
        session.commit();
    }


    @Test
    public void testGetMessageByIdName2(){
        System.out.println("查找出来的信息如下");
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teachers=mapper.getMessageByIdName2(3,"胡杰");
        for(Teacher T:teachers){
            System.out.println(T);
        }
        session.commit();
    }
}