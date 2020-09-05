package com.meng.feature.bean;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User implements Serializable {
    public String name;
    public int age;
    public User son;
    public User father;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.son = son;
    }

    /**
     * 转化为Result格式
     *
     * @param user 用户
     * @return
     */
    public static UserResult toResult(User user) {
        if (user == null) {
            return null;
        }
        UserResult userResult = new UserResult();
        userResult.setAge(user.age);
        userResult.setName(user.name);

        return userResult;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", son=" + (son == null ? null : son.getName()) +
                ", father=" + (father == null ? null : father.getName()) +
                '}';
    }
}
