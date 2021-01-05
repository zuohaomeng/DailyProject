package com.meng.zpattern.decorator.login.old;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public interface ISigninService {
    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    ResultMsg regist(String username, String password);


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    ResultMsg login(String username, String password);
}
