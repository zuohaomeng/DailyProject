package com.meng.daily.javabase.entity;

/**
 * @author ZuoHao
 * @date 2021/2/5
 */
public class Book2 {
    private int id;
    private String name;

    public Book2() {
    }

    public Book2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
