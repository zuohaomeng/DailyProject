package com.meng.zmysql.service;

import com.meng.zmysql.dao.Book;
import com.meng.zmysql.mapper.BookMapper;
import com.meng.zmysql.mapper.FruitMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZuoHao
 * @date 2021/1/26
 */
@SpringBootTest
class BookServiceImplTest {
    @Resource
    private BookServiceImpl bookService;
    @Resource
    private FruitMapper fruitMapper;
    @Resource
    private SqlSessionFactory sessionFactory;

    @Test
    public void insert() {
        Book book = Book.builder().name("3").description("3").build();
        bookService.delete(book);
        bookService.insert(book);
        bookService.insert(book);
    }

    @Test
    public void get() {
        SqlSession sqlSession = sessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        System.out.println(mapper.selectById(1));
        System.out.println("---------------我是时间的分割线-------");
        SqlSession sqlSession2 = sessionFactory.openSession();
        BookMapper mapper2 = sqlSession2.getMapper(BookMapper.class);
        System.out.println(mapper2.selectById(1));
        SqlSession sqlSession3 = sessionFactory.openSession();
        BookMapper mapper3 = sqlSession3.getMapper(BookMapper.class);
        System.out.println(mapper3.selectById(1));
    }

    @Test
    public void getCacheTwo(){
        System.out.println(bookService.getByName("3"));
        System.out.println(bookService.getByName("3"));
        System.out.println(bookService.getByName("3"));
        System.out.println("------------------------------");
        System.out.println(fruitMapper.selectById(1));
        System.out.println(fruitMapper.selectById(1));
        System.out.println(fruitMapper.selectById(1));

    }
}