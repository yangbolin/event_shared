/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.strategy;

import java.util.List;

import com.alibaba.event.AbstractEventListener;
import com.alibaba.event.EventContext;
import com.alibaba.event.exception.EventException;

/**
 * ��ITriggerEventStrategy.java��ʵ�������������¼��Ĳ��Խӿ�
 * 
 * @author yangbolin Sep 24, 2013 9:15:49 PM
 */
public interface ITriggerStrategy {

    /**
     * �����¼����Ե�ִ��
     * 
     * @param listenerList
     * @param eventContext
     * @throws EventException
     */
    public void execute(List<AbstractEventListener> listenerList, EventContext eventContext);
}
