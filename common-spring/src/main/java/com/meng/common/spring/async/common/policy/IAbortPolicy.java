package com.meng.common.spring.async.common.policy;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

/**
 * AbortPolicy：对拒绝任务抛弃处理，并且抛出异常。
 * @author ZuoHao
 * @date 2021/3/12
 */
public class IAbortPolicy extends AbortPolicy {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        super.rejectedExecution(r, executor);
    }
}
