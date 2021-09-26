package com.pctc.test;

import com.pctc.dao.FactoryMapper;
import com.pctc.dao.WorkerMapper;
import com.pctc.model.Factory;
import com.pctc.model.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestWorker {

    private SqlSession session;
    private SqlSession session1;
    private SqlSession session2;



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
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        this.session=session;

        SqlSession session1 = sqlSessionFactory.openSession();
        this.session1=session1;

        SqlSession session2 = sqlSessionFactory.openSession();
        this.session2=session2;

    }

    @Test
    public void TestGetWorker() {
        try {
    //01
            //缓存失效，发送三遍sql同样的sql语句进行数据库查找
           /* WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            WorkerMapper mapper1=session1.getMapper(WorkerMapper.class);
            WorkerMapper mapper2=session2.getMapper(WorkerMapper.class);

            Worker worker=mapper.getWorkerByid(1);
            System.out.println(worker);

            worker=mapper1.getWorkerByid(1);
            System.out.println(worker);

            worker=mapper2.getWorkerByid(1);
            System.out.println(worker);*/

  //02
          /* 一级缓存，sqlsession能缓存数据
          * 发送一次sql语句，得到两个Worker信息，见测试结果可知*/
          /*  WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = mapper.getWorkerByid(1);
            System.out.println(worker);

            worker = mapper.getWorkerByid(1);
            System.out.println(worker);*/


  //03
             /* 一级缓存，sqlsession能缓存数据
                发送一次sql语句，得到两个Worker信息，和02类似
                此次创建了两个对象，但结果和02一模一样.见测试结果可知*/
           /* WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = mapper.getWorkerByid(1);
            System.out.println(worker);

            Worker worker1 = mapper.getWorkerByid(1);
            System.out.println(worker1);*/

  //04

           /* 同一个SqlSession,同一个对象，但是查询条件不用
           一个传入年龄，一个传入年龄和姓名，执行两次sql
                            说明缓存失效*/
          /*  WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker=new Worker();
            worker.setAge(20);
            List<Worker> workers = mapper.getWorker(worker);
            for(Worker worker1:workers){
                System.out.println(worker1);
            }

            System.out.println("分-----割-----线");

            worker.setName("%帅%");
            worker.setAge(20);
            workers = mapper.getWorker(worker);
            for(Worker worker1:workers){
                System.out.println(worker1);
            }*/

  //05
            /*同一个SqlSession两次查询期间执行了任何一次增删改操作，缓存失效重新发送查询语句*/
          /*  Worker worker = new Worker();
            worker.setName("彭开东");
            worker.setAge(55);
            worker.setBirthday(new Date());
            worker.setFid(3);


            Worker worker1 = new Worker();
            worker1.setAge(20);

            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            List<Worker> workers = mapper.getWorker(worker1);
            for(Worker w:workers){
                System.out.println(w);
            }

            System.out.println("分-----割-----线");

            mapper.insertWorker(worker);
            session.commit();

            System.out.println("分-----割-----线");
            workers=mapper.getWorker(worker1);
            for(Worker w:workers){
                System.out.println(w);
            }*/


  //06
                /*手动清空缓存，缓存失效*/
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker = mapper.getWorkerByid(1);
            System.out.println(worker);

            session.clearCache();//手动清空缓存

            worker=mapper.getWorkerByid(1);
            System.out.println(worker);

        } finally {

        }
    }


    @Test
    public void TestGetWorker2() throws IOException{
        /*二级缓存，要同一个SqlSessionFactory
        从里面得到不同的SqlSession,二级缓存就SqlSession不同，SqlSession要关闭
        二级缓存是mapper级别的缓存*/
     try {
         WorkerMapper mapper = session.getMapper(WorkerMapper.class);
         Worker worker = new Worker();
         worker.setAge(20);
         List<Worker> workers = mapper.getWorker(worker);
         for (Worker w : workers) {
             System.out.println(w);
         }
         session.close();

         WorkerMapper mapper1 = session1.getMapper(WorkerMapper.class);
         List<Worker> workers1 = mapper1.getWorker(worker);
         for (Worker w : workers1) {
             System.out.println(w);
         }
         session1.close();

         WorkerMapper mapper2 = session2.getMapper(WorkerMapper.class);
         List<Worker> workers2 = mapper2.getWorker(worker);
         for (Worker w : workers2) {
             System.out.println(w);
         }
         session2.close();
     }finally {

     }
    }

    @Test
    public void TestGetFactoryId() throws IOException {
        /*用插件实行二级缓存，要同一个SqlSessionFactory
        从里面得到不同的SqlSession,二级缓存就SqlSession不同，SqlSession要关闭
        二级缓存是mapper级别的缓存*/
        try {
            FactoryMapper mapper = session.getMapper(FactoryMapper.class);
            Factory factory = mapper.getFactoryId(1);
            System.out.println(factory);
            session.close();


            FactoryMapper mapper1 = session1.getMapper(FactoryMapper.class);
            factory = mapper1.getFactoryId(1);
            System.out.println(factory);
            session1.close();


            FactoryMapper mapper2 = session2.getMapper(FactoryMapper.class);
            factory = mapper2.getFactoryId(1);
            System.out.println(factory);
            session2.close();
        } finally {

        }
    }
}
