package com.meng.zpattern.adapter.v2;

import com.meng.zpattern.adapter.v2.adapters.IPassportForThird;
import com.meng.zpattern.adapter.v2.adapters.PassportForThirdAdapter;

/**
 * @author ZuoHao
 * @date 2021/1/4
 */
public class PassportConsole {

    public static void main(String[] args) {

        IPassportForThird passportForThird = new PassportForThirdAdapter();

        passportForThird.loginForQQ("");


    }

}
