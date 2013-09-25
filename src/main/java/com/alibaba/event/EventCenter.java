/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

/**
 * 类EventCenter.java的实现描述：事件中心
 * @author yangbolin Sep 25, 2013 8:22:42 PM
 */
public class EventCenter extends AbstractEventCenter implements IEventCenter {

    @Override
    public void publish(String eventName, EventDTO eventDTO) {
        EventContext eventContext = new EventContext();
        eventContext.setEventName(eventName);
        eventContext.setEventDTO(eventDTO);
        super.trigger(eventContext);
    }

    @Override
    public void publish(String eventName) {
        EventContext eventContext = new EventContext();
        eventContext.setEventName(eventName);
        super.trigger(eventContext);
    }
}
