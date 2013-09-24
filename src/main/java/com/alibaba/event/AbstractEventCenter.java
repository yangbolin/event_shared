/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.event.strategy.ITriggerStrategy;
import com.alibaba.event.strategy.TriggerEventStrategyEnum;
import com.alibaba.event.strategy.impl.ConcurrentTriggerStrategyImpl;
import com.alibaba.event.strategy.impl.SerialTriggerStrategyImpl;

/**
 * 类AbstractEventCenter.java的实现描述： 抽象的事件中心
 * 
 * @author yangbolin Sep 24, 2013 9:25:39 PM
 */
public abstract class AbstractEventCenter {

    /** 触发事件的策略,目前有并行和串行两种 **/
    private static Map<TriggerEventStrategyEnum, ITriggerStrategy> strategyMap          = new ConcurrentHashMap<TriggerEventStrategyEnum, ITriggerStrategy>();
    /** 需要使用的触发策略，缺省使用串行 **/
    protected String                                               eventTriggerStrategy = "SERIAL";
    /** 监听者列表 **/
    protected List<IEventListener>                                 listenerList;
    /** 并发处理事件时的线程池大小 **/
    protected int                                                  poolSize;
    static {
        strategyMap.put(TriggerEventStrategyEnum.SERIAL, new SerialTriggerStrategyImpl());
        strategyMap.put(TriggerEventStrategyEnum.CONCURRENT, new ConcurrentTriggerStrategyImpl());
    }

    /**
     * 事件的触发
     * 
     * @param eventContext
     */
    public void trigger(EventContext eventContext) {
        // 先获取串行触发策略，作为缺省的触发策略
        ITriggerStrategy triggerStrategy = strategyMap.get(TriggerEventStrategyEnum.SERIAL);
        TriggerEventStrategyEnum strategyEnum = TriggerEventStrategyEnum.typeOf(eventTriggerStrategy);
        if (strategyEnum != null) {
            triggerStrategy = strategyMap.get(strategyEnum);
        }
        triggerStrategy.execute(listenerList, eventContext);
    }

    public String getEventTriggerStrategy() {
        return eventTriggerStrategy;
    }

    public void setEventTriggerStrategy(String eventTriggerStrategy) {
        this.eventTriggerStrategy = eventTriggerStrategy;
    }

    public void setListenerList(List<IEventListener> listenerList) {
        this.listenerList = listenerList;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}
