package com.pctc.test;

import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestWorker {

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
    public void TestGetWorker() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            worker.setId(1);
            worker.setName("%帅%");
            worker.setAge(10);
            List<Worker> list=mapper.getWorker(worker);
            System.out.println(list);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void TestGetWorker1() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            //worker.setId(1);
            worker.setName("%帅%");
            worker.setAge(10);
            List<Worker> list=mapper.getWorker1(worker);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void TestGetWorker2() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            worker.setId(1);
            worker.setName("%帅%");
            worker.setAge(10);
            List<Worker> list=mapper.getWorker2(worker);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void TestGetWorker3() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
           // worker.setId(1);
            //worker.setName("%帅%");
            worker.setAge(10);
            worker.setName("%帅%");
            List<Worker> list=mapper.getWorker3(worker);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void TestUpdateWorker() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            worker.setId(5);
            worker.setName("胡杰");
            worker.setAge(21);
            worker.setFid(1);
            int count = mapper.updateWorker(worker);
            session.commit();
            System.out.println(count);
        } finally {
            session.close();
        }
    }

    @Test
    public void TestGetWorker4() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            // worker.setId(1);
            //worker.setName("%帅%");
            worker.setAge(10);
            worker.setName("%帅%");
            List<Worker> list=mapper.getWorker4(worker);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void TestGetWorker5() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            // worker.setId(1);
            //worker.setName("%帅%");
            worker.setAge(10);
            worker.setName("%帅%");
            List<Worker> list=mapper.getWorker5(worker);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }



    @Test
    public void TestGetWorker6() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            List<Integer> list=new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            List<Worker> workers =mapper.getWorker6(list);
            for(Worker worker1 : workers){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void TestAddWorkerBatch() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);

             Worker worker=new Worker();
             worker.setName("刘斌");
             worker.setAge(50);
             worker.setBirthday(new Date());
             worker.setFid(3);

            Worker worker1=new Worker();
            worker1.setName("汪炳剑");
            worker1.setAge(30);
            worker1.setBirthday(new Date());
            worker1.setFid(3);


            List<Worker> list =new ArrayList<Worker>();
            list.add(worker);
            list.add(worker1);

            int count=mapper.addWorkerBatch(list);
            session.commit();
            System.out.println(count);
        } finally {
            session.close();
        }
    }


    @Test
    public void TestAddWorkerBatch1() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);

            Worker worker=new Worker();
            worker.setName("王鹏");
            worker.setAge(35);
            worker.setBirthday(new Date());
            worker.setFid(2);

            Worker worker1=new Worker();
            worker1.setName("刘鹏");
            worker1.setAge(22);
            worker1.setBirthday(new Date());
            worker1.setFid(1);


            List<Worker> list =new ArrayList<Worker>();
            list.add(worker);
            list.add(worker1);

            int count=mapper.addWorkerBatch1(list);
            session.commit();
            System.out.println(count);
        } finally {
            session.close();
        }
    }


    @Test
    public void TestGetWorker7() {
        try {
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = new Worker();
            // worker.setId(1);
            //worker.setName("%帅%");
            worker.setAge(10);
            worker.setName("%帅%");
            List<Worker> list=mapper.getWorker7(worker);
            for(Worker worker1 : list){
                System.out.println(worker1);
            }
        } finally {
            session.close();
        }
    }








}
