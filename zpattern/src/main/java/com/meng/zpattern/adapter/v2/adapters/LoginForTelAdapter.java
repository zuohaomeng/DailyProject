package com.meng.zpattern.adapter.v2.adapters;

import com.meng.zpattern.adapter.v2.ResultMsg;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class LoginForTelAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }
    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
