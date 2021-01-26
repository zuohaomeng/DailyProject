package com.meng.zmysql.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meng.zmysql.dao.Book;
import com.meng.zmysql.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZuoHao
 * @date 2021/1/26
 */
@Service
public class BookServiceImpl {
    @Resource
    private BookMapper bookMapper;


    public Book get(int id) {
        return bookMapper.selectById(id);
    }

    public Book getByName(String name) {
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        wrapper.lambda()
                .eq(Book::getName, name)
                .last("limit 1");
        return bookMapper.selectOne(wrapper);
    }

    public int insert(Book book) {
        return bookMapper.insert(book);
    }

    public int update(Book book) {
        return bookMapper.updateById(book);
    }

    public int deleteById(Integer id) {
        return bookMapper.deleteById(id);
    }

    public int delete(Book book) {
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        wrapper.lambda()
                .eq(Book::getName, book.getName());
        return bookMapper.delete(wrapper);
    }
}
