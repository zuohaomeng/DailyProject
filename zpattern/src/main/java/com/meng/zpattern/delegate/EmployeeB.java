package com.meng.zpattern.delegate;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我是员工B，我擅长散打，"+command);
    }
}
