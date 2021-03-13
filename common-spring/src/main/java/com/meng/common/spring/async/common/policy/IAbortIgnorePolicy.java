package com.meng.common.spring.async.common.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 不会抛出异常，只报error错误
 * @author ZuoHao
 * @date 2021/3/12
 */
public class IAbortIgnorePolicy extends ThreadPoolExecutor.AbortPolicy {

    private static final Logger logger = LoggerFactory.getLogger(IAbortIgnorePolicy.class);

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        logger.error("Task " + r.toString() + " rejected from " + executor.toString());
    }
}