package com.meng.common.spring.async.common.policy;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZuoHao
 * @date 2021/3/12
 */
public class IAbortPolicyFactory {
    public static final IAbortPolicy policy = new IAbortPolicy();

    public static final IAbortIgnorePolicy ignorePolicy = new IAbortIgnorePolicy();

    public static ThreadPoolExecutor.AbortPolicy getInstance() {
        return getInstance(0);
    }

    public static ThreadPoolExecutor.AbortPolicy getInstance(int type) {
        if(type == -1) {
            return policy;
        }
        return ignorePolicy;
    }
}
