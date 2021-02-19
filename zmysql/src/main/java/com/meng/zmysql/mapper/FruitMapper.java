package com.meng.zmysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meng.zmysql.entity.Fruit;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZuoHao
 * @date 2021/1/26
 */
@Mapper
public interface FruitMapper extends BaseMapper<Fruit> {
}
