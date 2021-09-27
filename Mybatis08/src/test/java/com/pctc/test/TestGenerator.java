package com.pctc.test;

import com.pctc.dao.WorkerMapper;
import com.pctc.model.Worker;
import com.pctc.model.WorkerExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestGenerator {

    private InputStream inputStream ;
    private SqlSession session;

    @Before
    public void read() throws Exception{

        inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        this.session=session;

    }

    @Test
    public void TestGetWorker() throws IOException{
        try{
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);
            Worker worker=mapper.selectByPrimaryKey(1);
            System.out.println(worker);
        }finally {
            session.close();
        }
    }

    @Test
    public void TestGetWorker1() throws  IOException{
        try{
            WorkerMapper mapper=session.getMapper(WorkerMapper.class);

            //查询全部信息
          /*
            WorkerExample example = null;
            List<Worker> workers = mapper.selectByExample(example);
            for(Worker w:workers){
                System.out.println(w);
            }*/

          //输入单个条件查询信息
           /* WorkerExample example = new WorkerExample();
            WorkerExample.Criteria criteria = example.createCriteria();
            criteria.andTAgeGreaterThan(new Integer("20"));

            List<Worker> workers = mapper.selectByExample(example);
            for(Worker w:workers){
                System.out.println(w);
            }*/

           //传入多个条件进行查询，使用and
           /* WorkerExample example = new WorkerExample();
            WorkerExample.Criteria criteria = example.createCriteria();
            criteria.andTAgeGreaterThan(new Integer("20"));
            criteria.andTNameLike("%帅%");

            List<Worker> workers = mapper.selectByExample(example);
            for(Worker w:workers){
                System.out.println(w);
            }*/

            //输入多条件查询用or
           /* WorkerExample example = new WorkerExample();
            WorkerExample.Criteria criteria = example.createCriteria();
            criteria.andTAgeGreaterThan(new Integer(20));
            criteria.andTNameLike("%帅%");

            WorkerExample.Criteria criteria1 = example.createCriteria();
            criteria1.andTFidLessThanOrEqualTo(new Integer(2));

            example.or(criteria1);
            List<Worker> workers=mapper.selectByExample(example);
            for(Worker w:workers){
                System.out.println(w);
            }*/


           //排序

           /* WorkerExample example = new WorkerExample();
            WorkerExample.Criteria criteria = example.createCriteria();
            criteria.andTAgeGreaterThan(new Integer(20));
            criteria.andTNameLike("%帅%");
            WorkerExample.Criteria criteria1 = example.createCriteria();
            criteria1.andTFidLessThanOrEqualTo(new Integer(2));

            example.or(criteria1);
            example.setOrderByClause("t_age desc,t_id asc");

            List<Worker> workers=mapper.selectByExample(example);
            for(Worker w:workers){
                System.out.println(w);
            }*/


           //统计
            WorkerExample example = new WorkerExample();
            WorkerExample.Criteria criteria = example.createCriteria();
            criteria.andTAgeGreaterThan(new Integer(20));
            criteria.andTNameLike("%帅%");
            int count = mapper.countByExample(example);
            System.out.println(count);






        }
        finally {
            session.close();
        }
    }



}
