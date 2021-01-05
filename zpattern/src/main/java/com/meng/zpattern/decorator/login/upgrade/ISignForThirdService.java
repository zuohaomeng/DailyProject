package com.meng.zpattern.decorator.login.upgrade;

import com.meng.zpattern.decorator.login.old.ISigninService;
import com.meng.zpattern.decorator.login.old.ResultMsg;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public interface ISignForThirdService extends ISigninService {
    /**
     * QQ登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     * @param telphone
     * @param code
     * @return
     */
    ResultMsg loginForTelphone(String telphone, String code);

    /**
     * 注册后自动登录
     * @param username
     * @param passport
     * @return
     */
    ResultMsg loginForRegist(String username, String passport);

}
