package com.meng.daily.javabase.jvm;

import com.meng.daily.javabase.bean.Book;

/**
 * @author ZuoHao
 * @date 2021/9/11
 */
public class MyClassLoader extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args) {
        Book book = new Book();
    }
}
