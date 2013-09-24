/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

/**
 * <pre>
 * 类IEventCenter.java的实现描述：事件中心的接口
 * 
 * 客户端可以定制自己的事件中心，定制的时候需要实现这个接口 
 * </pre>
 * 
 * @author yangbolin Sep 24, 2013 9:18:42 PM
 */
public interface IEventCenter {
    /**
     * 事件的发布
     * @param eventName 事件名称
     * @param eventDTO  发布事件时的数据传输对象
     */
    public void publish(String eventName, EventDTO eventDTO);
    /**
     * 事件的发布
     * @param eventName 事件名称
     */
    public void publish(String eventName);
}
