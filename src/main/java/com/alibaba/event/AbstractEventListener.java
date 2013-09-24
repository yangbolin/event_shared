/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.event.exception.EventException;

/**
 * 类AbstractEventListener.java的实现描述：事件监听者的抽象类
 * 
 * @author yangbolin Sep 24, 2013 8:17:45 PM
 */
public abstract class AbstractEventListener {

    /** 一个监听者感兴趣的事件列表 **/
    protected List<EventModel> eventList = new ArrayList<EventModel>();

    /**
     * 最先注册的事件优先被响应
     * 
     * @param eventContext
     */
    public void response(EventContext eventContext) throws EventException {
        if (eventContext == null) {
            return;
        }

        String triggerEventName = eventContext.getEventName();
        if (StringUtils.isBlank(triggerEventName)) {
            return;
        }

        EventDTO eventDTO = eventContext.getEventDTO();
        for (EventModel eventModel : eventList) {
            try {
                String eventName = eventModel.getEventName();
                if (triggerEventName.equals(eventName)) {
                    IEventCallBack eventCallBack = eventModel.getEventCallBack();
                    if (eventCallBack == null) {
                        throw new EventException(String.format("can't get call back for event=%s", triggerEventName));
                    } else {
                        /***************************************************
                         * 一个监听者只能对一个事件监听一次，不允许对同一个事件监听多次
                         ***************************************************/
                        eventCallBack.execute(eventDTO);
                        break;
                    }
                }
            } catch (Exception e) {
                throw new EventException(e.getMessage(), e.getCause());
            }
        }
    }

    public void setEventList(List<EventModel> eventList) {
        this.eventList = eventList;
    }
}
