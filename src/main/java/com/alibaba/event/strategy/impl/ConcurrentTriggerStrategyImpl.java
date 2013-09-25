/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.strategy.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;

import com.alibaba.event.AbstractEventListener;
import com.alibaba.event.EventContext;
import com.alibaba.event.exception.EventException;
import com.alibaba.event.strategy.ITriggerStrategy;

/**
 * ��ConcurrentTriggerStrategyImpl.java��ʵ����������������
 * 
 * @author yangbolin Sep 24, 2013 9:36:34 PM
 */
public class ConcurrentTriggerStrategyImpl implements ITriggerStrategy, DisposableBean {

    private static final Log log = LogFactory.getLog(ConcurrentTriggerStrategyImpl.class);
    /** �̳߳صĴ�С **/
    private int              threadPoolSize;
    /** �̳߳� **/
    private ExecutorService  executorService;

    public ConcurrentTriggerStrategyImpl(int threadPoolSize){
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    public void execute(List<AbstractEventListener> listenerList, EventContext eventContext) {
        
        /** �̳߳صĳ�ʼ�� **/
        initThreadPool();

        final EventContext innerEventContext = eventContext;
        for (AbstractEventListener listener : listenerList) {
            final AbstractEventListener innerListener = listener;
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        if (log.isDebugEnabled()) {
                            log.debug(String.format("concurrent start trigger event=%s listener=%s",
                                                    innerEventContext.getEventName(), innerListener.getClass()));
                        }
                        innerListener.response(innerEventContext);
                        if (log.isDebugEnabled()) {
                            log.debug(String.format("concurrent end trigger event=%s listener=%s",
                                                    innerEventContext.getEventName(), innerListener.getClass()));
                        }
                    } catch (EventException e) {
                        log.error(String.format("trigger event for listener exception event=%s listener=%s",
                                                innerEventContext.getEventName(), innerListener.getClass()), e);
                    } catch (Exception e) {
                        log.error(e);
                    }
                }
            });
        }
    }

    private void initThreadPool() {
        /** �̳߳�ֻ��ʼ��һ�� **/
        if (executorService != null) {
            return;
        }

        /** ����һ���̶���С���̳߳� **/
        executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    public void destroy() throws Exception {
        executorService.shutdown();
    }
}
