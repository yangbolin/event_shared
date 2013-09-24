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
 * 类EventContext.java的实现描述：事件上下文
 * 
 * @author yangbolin Sep 24, 2013 8:06:41 PM
 */
public class EventContext implements Serializable {

    private static final long serialVersionUID = 8595357858356593055L;

    /** 事件名称 **/
    private String            eventName;
    /** 事件的数据传输对象 **/
    private EventDTO          eventDTO;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }
}
