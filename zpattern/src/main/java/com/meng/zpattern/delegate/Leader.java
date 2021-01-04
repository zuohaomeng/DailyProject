package com.meng.zpattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 分配任务的leader
 * @author ZuoHao
 * @date 2021/1/3
 */
public class Leader {
    //预先知道每个员工的特长
    private Map<String,IEmployee> register = new HashMap<>();
    public Leader(){
        register.put("拳击",new EmployeeA());
        register.put("散打",new EmployeeB());
    }




    public void doing(String command){
        IEmployee employee = register.get(command);
        if (employee != null){
            employee.doing(command);
        }else {
            System.out.println("招新员工吧");
        }
    }
}
