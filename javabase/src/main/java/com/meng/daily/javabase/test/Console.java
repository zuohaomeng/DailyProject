package com.meng.daily.javabase.test;

import com.meng.daily.javabase.entity.Book;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020/10/23 10:19
 */
public class Console {
    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1394394161);
        long memebrId = book.getId();
        long ios = 1394394161L;
        System.out.println(ios == memebrId);

    }
}
