package com.meng.zpattern.template.jdbc;

import java.util.List;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public class MemberDaoConsole {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
