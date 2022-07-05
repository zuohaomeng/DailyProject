package com.meng.daily.javabase.jvm;

import java.io.Serializable;

/**
 * @author ZuoHao
 * @date 2021/9/22
 */
public class DiscountSmsRecord {
    private Long memberId;
    private Integer configType;

    public DiscountSmsRecord(Long memberId, Integer configType) {
        this.memberId = memberId;
        this.configType = configType;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

}
