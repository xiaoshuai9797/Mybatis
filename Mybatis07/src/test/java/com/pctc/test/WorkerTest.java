package com.pctc.test;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class WorkerTest {


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

    /*手动分页*/
    @Test
    public void TestSelectWorkerPage(){
        WorkerMapper mapper=session.getMapper(WorkerMapper.class);
        int page=2;
        int number=3;
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("recordNum",(page-1)*number);
        map.put("pageSize",number);

        List<Worker> workers=mapper.selectWorkerPage(map);
        for(Worker w:workers){
            System.out.println(w);
        }

        session.close();
    }


    /*插件分页*/
    @Test
    public void TestSelectWorkerPagePlug() {
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);

        Worker worker=new Worker();
        worker.setName("帅");
        worker.setAge(20);

        int pageNum=1;
        int pageSize=3;

        Page<Worker> page = PageHelper.startPage(pageNum,pageSize);
        List<Worker> workers = mapper.selectWorkerPagePlug(worker);
        for(Worker w:workers){
            System.out.println(w);
        }

        System.out.println("当前页码:"+page.getPageNum());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("每页几个数据:"+page.getPageSize());
        System.out.println("总页码:"+page.getPages());

        session.close();
    }

    @Test
    public void TestSelectWorkerPagePlugComplex() {
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        Worker worker=new Worker();
      /*  worker.setAge(20);
        worker.setName("帅");*/

        int pageNum=4;
        int pageSize=3;
        Page<Worker> page = PageHelper.startPage(pageNum,pageSize);
        List<Worker> workers=mapper.selectWorkerPagePlug(worker);

        PageInfo<Worker> info = new PageInfo<Worker>(workers,3);
        for(Worker w:workers){
            System.out.println(w);
        }
        System.out.println("当前页码:"+page.getPageNum());
        System.out.println("总记录数:"+page.getTotal());
        System.out.println("每页几个数据:"+page.getPageSize());
        System.out.println("总页码:"+page.getPages());
        System.out.println("连续显示的页码:");
        int[]nums = info.getNavigatepageNums();
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

        session.close();
    }

}
