package com.meng.zpattern.adapter.v2.adapters;


import com.meng.zpattern.adapter.v2.ResultMsg;

/**
 * 在适配器里面，这个接口是可有可无，不要跟模板模式混淆
 * 模板模式一定是抽象类，而这里仅仅只是一个接口
 * @author ZuoHao
 * @date 2021/1/4
 */
public interface LoginAdapter {
    /**
     * 是否支持
     * @param adapter
     * @return
     */
    boolean support(Object adapter);

    /**
     * 登录
     * @param id
     * @param adapter
     * @return
     */
    ResultMsg login(String id, Object adapter);

}
