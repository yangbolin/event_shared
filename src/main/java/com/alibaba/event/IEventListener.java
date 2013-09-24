/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

import com.alibaba.event.exception.EventException;

/**
 * <pre>
 * 类IEventListener.java的实现描述：事件监听者的接口
 * 
 * 一个事件可以被多个监听者监听，一个监听者可以监听多个事件
 * </pre>
 * 
 * @author yangbolin Sep 24, 2013 7:59:13 PM
 */
public interface IEventListener {

    /**
     * 给事件监听者注册一个事件以及相应的回调
     * 
     * @param eventName 事件名称
     * @param eventCallBack 事件的回调
     * @throws EventException 事件的异常
     */
    public void addEvent(String eventName, IEventCallBack eventCallBack) throws EventException;

    /**
     * 删除监听者监听的一个事件
     * 
     * @param eventName 事件名称
     * @throws EventException 事件的异常
     */
    public void delEvent(String eventName) throws EventException;
}
