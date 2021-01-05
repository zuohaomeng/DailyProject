package com.meng.zpattern.decorator.login.upgrade;

import com.meng.zpattern.decorator.login.old.ISigninService;
import com.meng.zpattern.decorator.login.old.ResultMsg;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public class SignForThirdServiceImpl implements ISignForThirdService{
    private ISigninService signinService;

    public SignForThirdServiceImpl(ISigninService signinService) {
        this.signinService = signinService;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return signinService.regist(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return signinService.login(username, password);
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return this.login(id,"正确密码");
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }
}
