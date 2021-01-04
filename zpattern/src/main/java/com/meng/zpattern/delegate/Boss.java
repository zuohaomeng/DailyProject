package com.meng.zpattern.delegate;

/**
 * 下达任务的boss
 * @author ZuoHao
 * @date 2021/1/3
 */
public class Boss {
    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
