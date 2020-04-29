package cn.javasm;

import cn.javasm.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.*;


import java.util.List;
import java.util.Map;

public class test {
    private static SessionFactory sessionFactory = null;
    private Session session = null;

    @BeforeClass
    public static void initFactory() {
        //加载hibernate.cfg.xml文件，并创建sessionFactory对象
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Before
    public void initSession() {
        session = sessionFactory.openSession();
    }

    @Test
    public void test1() {
        //数据库操作
        //按主键查询数据
        Book book = session.get(Book.class, 1);
        System.out.println(book);
    }

    @Test
    public void test2() {
        //开启事务
        Transaction transaction = session.beginTransaction();
        Book book = new Book();
        book.setName("斗罗大陆2");
        book.setAuthorName("唐家三少");
        book.setType("异世大陆");
        //手动提交事务
        transaction.commit();
        //把对象持久化到数据库
        session.save(book);
    }

    @Test
    public void test3() {
        //查询所有
        Query query = session.createQuery("from Book");
        //分页
        query.setFirstResult(0);
        query.setMaxResults(2);
        List list = query.list();
        System.out.println(list);


    }

    @Test
    public void test4() {
        //条件查询
        Query query = session.createQuery("from Book where name=:n");
        query.setParameter("n", "斗罗大陆");
        Book book = (Book) query.uniqueResult();
        System.out.println(book);
    }

    @Test
    public void test5() {
        //多变量查询
        Query query = session.createQuery(" select new Book (bid,name) from Book where name=:n");
        query.setParameter("n", "斗罗大陆");
        Book book = (Book) query.uniqueResult();
        System.out.println(book);
    }

    @Test
    public void test7() {
        //模糊查询
        Query query = session.createQuery(" from Book where  name like :n");
        query.setParameter("n", "斗%");
        List list = query.list();
        System.out.println(list);
    }

    @Test
    public void test6() {
        //多变量查询,把多列表封装到map中
        Query query = session.createQuery(" select new map (bid,name) from Book where name=:n");
        query.setParameter("n", "斗罗大陆");
        Map book = (Map) query.uniqueResult();
        System.out.println(book);
    }

    @AfterClass
    public static void closeFactory() {
        sessionFactory.close();
    }


    @After
    public void closeSession() {
        session.close();
    }
}
