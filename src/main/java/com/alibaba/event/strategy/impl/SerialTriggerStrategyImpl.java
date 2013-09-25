/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.strategy.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.event.AbstractEventListener;
import com.alibaba.event.EventContext;
import com.alibaba.event.exception.EventException;
import com.alibaba.event.strategy.ITriggerStrategy;

/**
 * 类SerialTriggerStrategyImpl.java的实现描述：串行触发
 * 
 * @author yangbolin Sep 24, 2013 9:35:23 PM
 */
public class SerialTriggerStrategyImpl implements ITriggerStrategy {

    private static final Log log = LogFactory.getLog(SerialTriggerStrategyImpl.class);

    @Override
    public void execute(List<AbstractEventListener> listenerList, EventContext eventContext) {
        if (listenerList == null || listenerList.size() == 0) {
            return;
        }
        if (eventContext == null) {
            return;
        }

        for (AbstractEventListener listener : listenerList) {
            try {
                if (log.isDebugEnabled()) {
                    log.debug(String.format("serial start trigger event=%s listener=%s", eventContext.getEventName(),
                                            listener.getClass()));
                }

                listener.response(eventContext);
                if (log.isDebugEnabled()) {
                    log.debug(String.format("serial end trigger event=%s listener=%s", eventContext.getEventName(),
                                            listener.getClass()));
                }
            } catch (EventException e) {
                log.error(String.format("serial trigger event=%s listener=%s exception", eventContext.getEventName(),
                                        listener.getClass()), e);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
}
