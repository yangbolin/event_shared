/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

import java.io.Serializable;

/**
 * <pre>
 * 类EventModel.java的实现描述：事件模型 
 * 
 * 客户端可以定制自己的事件模型，当然自己定制的这个事件模型需要从EventModel类
 * 派生而来
 * </pre>
 * 
 * @author yangbolin Sep 24, 2013 8:10:51 PM
 */
public class EventModel implements Serializable {

    private static final long serialVersionUID = -2908358732553236493L;
    /** 事件的名称 **/
    protected String          eventName;
    /** 事件的回调 **/
    protected IEventCallBack  eventCallBack;

    public EventModel() {
    }
    public EventModel(String eventName, IEventCallBack eventCallBack){
        this.eventName = eventName;
        this.eventCallBack = eventCallBack;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public IEventCallBack getEventCallBack() {
        return eventCallBack;
    }

    public void setEventCallBack(IEventCallBack eventCallBack) {
        this.eventCallBack = eventCallBack;
    }
}
