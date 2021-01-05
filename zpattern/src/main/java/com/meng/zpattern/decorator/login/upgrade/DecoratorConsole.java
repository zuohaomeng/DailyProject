package com.meng.zpattern.decorator.login.upgrade;

import com.meng.zpattern.decorator.login.old.SigninService;

/**
 * @author ZuoHao
 * @date 2021/1/5
 */
public class DecoratorConsole {
    public static void main(String[] args) {
        ISignForThirdService signForThirdService = new SignForThirdServiceImpl(new SigninService());
        signForThirdService.loginForQQ("178183828");
    }
}
