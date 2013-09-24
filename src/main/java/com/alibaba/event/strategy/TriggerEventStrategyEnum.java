/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.strategy;

import org.apache.commons.lang3.StringUtils;

/**
 * 类TriggerEventStrategyEnum.java的实现描述：事件触发的策略枚举
 * 
 * @author yangbolin Sep 24, 2013 8:46:52 PM
 */
public enum TriggerEventStrategyEnum {
    /** 串行 **/
    SERIAL("SERIAL"),
    /** 并发 **/
    CONCURRENT("CONCURRENT");

    String value;

    TriggerEventStrategyEnum(String value){
        this.value = value;
    }

    /**
     * 把一个字符串转换成枚举类型
     * 
     * @param value
     * @return
     */
    public static TriggerEventStrategyEnum typeOf(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (TriggerEventStrategyEnum strategy : TriggerEventStrategyEnum.values()) {
            if (strategy.getValue().equals(value)) {
                return strategy;
            }
        }
        return null;
    }
    
    public String getValue() {
        return value;
    }
}
