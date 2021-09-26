package com.pctc.test;

import com.pctc.dao.FactoryMapper;
import com.pctc.model.Factory;
import com.pctc.model.WorkerFactoryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestFactory {

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
    public void TestGetFactoryById() {
        try {
            FactoryMapper mapper=session.getMapper(FactoryMapper.class);
            Factory factory=mapper.getFactoryById(2);
            System.out.println(factory);

        } finally {
            session.close();
        }
    }

    @Test
    public void TestGetFactoryById1() {
        try {
            FactoryMapper mapper=session.getMapper(FactoryMapper.class);
            Factory factory=mapper.getFactoryById1(2);
            System.out.println(factory);

        } finally {
            session.close();
        }

    }

    @Test
    public void TestGetFactoryById2() {
        try {
            FactoryMapper mapper=session.getMapper(FactoryMapper.class);
            Factory factory=mapper.getFactoryById2(2);
            System.out.println(factory);

        } finally {
            session.close();
        }
    }

    @Test
    public void TestGetFactoryIdVo() {
        try {
            FactoryMapper mapper=session.getMapper(FactoryMapper.class);
            List<WorkerFactoryVo> factorys=mapper.getFactoryIdVo(1);
            System.out.println(factorys);

        } finally {
            session.close();
        }
    }


}
