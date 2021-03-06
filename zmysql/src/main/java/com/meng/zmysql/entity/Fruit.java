package com.meng.zmysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author ZuoHao
 * @date 2021/1/26
 */
@Builder
@Data
@TableName("fruit")
public class Fruit {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String description;
}
