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
 * ��AbstractEventCenter.java��ʵ�������� ������¼�����
 * 
 * @author yangbolin Sep 24, 2013 9:25:39 PM
 */
public abstract class AbstractEventCenter {

    /** �����¼��Ĳ���,Ŀǰ�в��кʹ������� **/
    private static Map<TriggerEventStrategyEnum, ITriggerStrategy> strategyMap          = new ConcurrentHashMap<TriggerEventStrategyEnum, ITriggerStrategy>();
    /** ��Ҫʹ�õĴ������ԣ�ȱʡʹ�ô��� **/
    protected String                                               eventTriggerStrategy = "SERIAL";
    /** �������б� **/
    protected List<IEventListener>                                 listenerList;
    /** ���������¼�ʱ���̳߳ش�С **/
    protected int                                                  poolSize;
    static {
        strategyMap.put(TriggerEventStrategyEnum.SERIAL, new SerialTriggerStrategyImpl());
        strategyMap.put(TriggerEventStrategyEnum.CONCURRENT, new ConcurrentTriggerStrategyImpl());
    }

    /**
     * �¼��Ĵ���
     * 
     * @param eventContext
     */
    public void trigger(EventContext eventContext) {
        // �Ȼ�ȡ���д������ԣ���Ϊȱʡ�Ĵ�������
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
