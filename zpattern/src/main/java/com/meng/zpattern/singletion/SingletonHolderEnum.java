package com.meng.zpattern.singletion;

/**
 * 枚举式单例模式中的枚举类
 * @author ZuoHao
 * @date 2021/1/2
 */
public enum SingletonHolderEnum {
    /**
     * 枚举单例持有对象
     */
    INSTANCE;

    //需要创建的枚举类
    private Object data;

    public Object getData() {
        return data;
    }

}
