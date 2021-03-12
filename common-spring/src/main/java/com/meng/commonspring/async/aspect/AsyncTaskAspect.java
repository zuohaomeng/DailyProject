package com.meng.commonspring.async.aspect;

import com.meng.commonspring.async.annotation.AsyncTask;
import com.meng.commonspring.async.bean.ThreadInfo;
import com.meng.commonspring.async.common.ICallable;
import com.meng.commonspring.async.common.IRunnable;
import com.meng.commonspring.async.common.IScheRunnable;
import com.meng.commonspring.async.executor.IExecutor;
import com.meng.commonspring.async.executor.IExecutorFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * 异步执行方法切面
 *
 * 标注该注解的类下，所有方法的执行会通过线程池异步执行
 * @author ZuoHao
 * @date 2021/3/12
 */
@Aspect
@Component
public class AsyncTaskAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(AsyncTaskAspect.class);

    @Resource
    private IExecutorFactory iExecutorFactory;

    /**
     * 对返回值为void的异步任务切面处理
     */
    @Around("@within(asyncTask) && bean(*Async) && execution(public Object *.*(..))")
    public Object dealObjectAspect(final ProceedingJoinPoint joinPoint, AsyncTask asyncTask) throws Throwable {

        final IExecutor executor = IExecutorFactory.get(asyncTask.value());
        if (executor.isSchedule()) {
            return dealScheduleAspect(joinPoint, executor, asyncTask);
        }

        ThreadInfo threadInfo = new ThreadInfo(executor.getProject(), asyncTask.value(), joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());

        Future<?> future = executor.submit(new ICallable<Object>(threadInfo) {
            @Override
            public Object icall() throws Exception {
                try {
                    return joinPoint.proceed();

                } catch (Throwable e) {
                    LOGGER.error("[" + this.getThreadInfo() + "] async excute error ", e);
                }
                return null;
            }

            @Override
            public void ienter() {
                executor.addThread(this.getThreadInfo());
            }

            @Override
            public void iexst() throws Exception {
                executor.removeThread(this.getThreadInfo().getId());
            }
        });

        return future;
    }

    /**
     * 对返回值为Object的异步任务切面处理
     */
    @Around("@within(asyncTask) && bean(*Async) && execution(public void *.*(..))")
    public Object dealVoidAspect(final ProceedingJoinPoint joinPoint, AsyncTask asyncTask) throws Throwable {

        final IExecutor executor = IExecutorFactory.get(asyncTask.value());

        if (executor.isSchedule()) {
            return dealScheduleAspect(joinPoint, executor, asyncTask);
        }

        ThreadInfo threadInfo = new ThreadInfo(executor.getProject(), asyncTask.value(), joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());

        executor.execute(new IRunnable(threadInfo) {
            @Override
            public void irun() {
                try {
                    joinPoint.proceed();
                } catch (Throwable e) {
                    LOGGER.error("[" + this.getThreadInfo() + "] async excute error ", e);
                }
            }

            @Override
            public void ienter() {
                executor.addThread(this.getThreadInfo());
            }

            @Override
            public void iexst() {
                executor.removeThread(this.getThreadInfo().getId());
            }
        });
        return null;
    }

    /**
     * 对异步定时任务做处理
     */
    private Object dealScheduleAspect(final ProceedingJoinPoint joinPoint, final IExecutor executor, AsyncTask asyncTask) {

        ThreadInfo threadInfo = new ThreadInfo(executor.getProject(), asyncTask.value(), joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());

        executor.schedule(new IScheRunnable(threadInfo) {

            @Override
            public void irun() {
                try {
                    joinPoint.proceed();
                } catch (Throwable e) {
                    LOGGER.error("[" + this.getThreadInfo() + "] async excute error ", e);
                }
            }

            @Override
            public void ienter() {
                executor.addThread(this.getThreadInfo());
            }

            @Override
            public void iexst() {
                executor.removeThread(this.getThreadInfo().getId());
            }
        });

        return null;
    }
}
