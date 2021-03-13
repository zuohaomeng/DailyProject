package com.meng.common.spring.async.executor;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.meng.common.spring.async.annotation.AsyncTask;
import com.meng.common.spring.async.bean.ControlContext;
import com.meng.common.spring.async.bean.ScheduleInfo;
import com.meng.common.spring.async.config.AsyncConfig;
import com.meng.common.spring.async.config.PoolParam;
import com.meng.common.spring.async.common.policy.IAbortPolicyFactory;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Executor生成工厂
 *
 * @author ZuoHao
 * @date 2021/3/12
 */
@Component
public class IExecutorFactory {

    @Resource
    private ApplicationContext applicationContext;

    private static final Logger LOGGER = LoggerFactory.getLogger(IExecutorFactory.class);

    /**
     * 线程池
     */
    private static Map<String, IExecutor> map = new HashMap<>();


    @Resource
    private AsyncConfig asyncConfig;

    /**
     * 获取线程池
     *
     * @param
     * @return
     */
    public static IExecutor get(String module) {
        return map.get(module);
    }

    public static Set<String> getAllExecutorName() {
        return map.keySet();
    }

    @PostConstruct
    public void init() throws Exception {

        //用自动装配的属性生成本地线程池
        Map<String, PoolParam> poolParams = asyncConfig.getExecutor();
        Iterator<String> moduleNameIterator = poolParams.keySet().iterator();
        while (moduleNameIterator.hasNext()) {
            String moduleName = moduleNameIterator.next();
            PoolParam poolParam = poolParams.get(moduleName);
            IExecutor iexecutor = generateIExecutor(poolParam, asyncConfig.getProjectName(), moduleName);
            map.put(moduleName, iexecutor);
        }

        checkValid();
    }

    /**
     * 校验异步任务，检查线程池存在
     */
    private void checkValid() {
        Map<String, Object> beansWithAnnotationMap = applicationContext.getBeansWithAnnotation(AsyncTask.class);
        for (Object bean : beansWithAnnotationMap.values()) {
            AsyncTask asyncTask = bean.getClass().getAnnotation(AsyncTask.class);
            if (IExecutorFactory.get(asyncTask.value()) == null) {
                throw new RuntimeException(bean + " 不存在线程池模块 : " + asyncTask.value());
            }
        }
    }

    /**
     * 依赖自动装配来生成IExecutor
     *
     * @param poolParam
     * @param projectName
     * @param moduleName
     * @return
     */
    private IExecutor generateIExecutor(PoolParam poolParam, String projectName, String moduleName) {

        // 遗留问题字段兼容
        int coreSize = poolParam.getCoreSize();
        // 等待队列增加个10000大小限制，避免无界
        int queueSize = poolParam.getQueueSize() == 0 ? 10000 : poolParam.getQueueSize();
        int reportType = poolParam.getReportType() == 0 ? 1 : poolParam.getReportType();
        long schedulePeriod = poolParam.getSchedulePeriod();
        long scheduleDelay = poolParam.getScheduleDelay();
        int rejectType = poolParam.getRejectType();
        // 定时时间单位
        String scheduleUnitStr = poolParam.getScheduleUnit();
        TimeUnit scheduleUnit = StringUtils.isBlank(scheduleUnitStr) ? TimeUnit.MILLISECONDS : TimeUnit.valueOf(scheduleUnitStr);
        ExecutorService executor = null;
        if (IExecutor.isSchedule(schedulePeriod, scheduleDelay)) {

            //ttl包装
            executor = TtlExecutors.getTtlScheduledExecutorService(new ScheduledThreadPoolExecutor(coreSize, Executors.defaultThreadFactory(), IAbortPolicyFactory.getInstance(rejectType)));

        } else {
            BlockingQueue<Runnable> queue = queueSize > 0 ? new ArrayBlockingQueue<Runnable>(queueSize) : new LinkedBlockingQueue<Runnable>();

            executor = new ThreadPoolExecutor(coreSize, coreSize, 0L, TimeUnit.MILLISECONDS, queue, Executors.defaultThreadFactory(), IAbortPolicyFactory.getInstance(rejectType));

            //ttl包装
            executor = TtlExecutors.getTtlExecutorService(executor);
        }

        return new IExecutor(projectName, moduleName, executor, new ScheduleInfo(schedulePeriod, scheduleDelay, scheduleUnit));
    }


    public static void main(String[] args) throws Exception {
        ExecutorService executor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), IAbortPolicyFactory.getInstance());
        ExecutorService executorService = TtlExecutors.getTtlExecutorService(executor);
        ControlContext.add("t2", "vvv");
        for (int i = 1; i <= 5; i++) {
            ControlContext.add("t1", i + "");
            final int count = i;

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int n = count;
                    try {
                        long st = RandomUtils.nextLong(100, 100);
                        if (n == 1) {
                            st = 3000;
                        }
                        Thread.sleep(st);
                    } catch (Exception e) {
                    }
                    System.out.println(n + " ==" + ControlContext.get("t1", String.class));
                    ControlContext.add("t2", "ss");
                }
            });

            Thread.sleep(1000);
        }
    }
}