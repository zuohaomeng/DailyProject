package com.meng.zmysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.zmysql.dao.Book;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZuoHao
 * @date 2021/1/26
 */

@Mapper
//只有有了这个注解才会使用二级缓存，MyBatis的规则
@CacheNamespace
public interface BookMapper extends BaseMapper<Book> {
}
