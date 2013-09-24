/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.strategy.impl;

import java.util.List;

import com.alibaba.event.EventContext;
import com.alibaba.event.IEventListener;
import com.alibaba.event.strategy.ITriggerStrategy;

/**
 * ��SerialTriggerStrategyImpl.java��ʵ�����������д��� 
 * @author yangbolin Sep 24, 2013 9:35:23 PM
 */
public class SerialTriggerStrategyImpl implements ITriggerStrategy {

    @Override
    public void execute(List<IEventListener> listenerList, EventContext eventContext) {
        // TODO 
    }
}
