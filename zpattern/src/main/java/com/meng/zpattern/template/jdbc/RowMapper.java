package com.meng.zpattern.template.jdbc;

import java.sql.ResultSet;

/**
 * @author ZuoHao
 * @date 2021/1/3
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs,int rowNum) throws Exception;
}
