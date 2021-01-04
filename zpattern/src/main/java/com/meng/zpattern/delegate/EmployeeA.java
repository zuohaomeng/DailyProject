package com.meng.zpattern.delegate;

/**
 * 苦逼员工A
 *
 * @author ZuoHao
 * @date 2021/1/3
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("我的员工A，我擅长拳击，" + command);
    }
}
