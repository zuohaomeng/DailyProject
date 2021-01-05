package com.meng.zpattern.adapter.v2.adapters;


import com.meng.zpattern.adapter.v2.ResultMsg;
import com.meng.zpattern.adapter.v2.SiginService;

/**
 * 结合策略模式、工厂模式、适配器模式
 * @author ZuoHao
 * @date 2021/1/4
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird {

    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        super.regist(username,passport);
        return super.login(username,passport);
    }

    private ResultMsg processLogin(String key,Class<? extends LoginAdapter> clazz){
        try{
            //适配器不一定要实现接口
            LoginAdapter adapter = clazz.newInstance();

            //判断传过来的适配器是否能处理指定的逻辑
            if(adapter.support(adapter)){
                return adapter.login(key,adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //类图的快捷键  Ctrl + Alt + Shift + U
}
