/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.event.exception.EventException;

/**
 * 类EventListener.java的实现描述：事件监听者
 * 
 * @author yangbolin Sep 25, 2013 8:44:56 PM
 */
public class EventListener extends AbstractEventListener implements IEventListener {

    private static final Log log = LogFactory.getLog(EventListener.class);

    @Override
    public boolean addEvent(String eventName, IEventCallBack eventCallBack) throws EventException {
        if (StringUtils.isBlank(eventName)) {
            return false;
        }

        // 先查找事件是否已经增加过
        for (EventModel event : eventList) {
            if (event.getEventName().equals(eventName)) {
                log.error(String.format("add event=%s for listener=%s duplicated!!!", eventName, this.getClass()));
                return false;
            }
        }
        EventModel eventModel = new EventModel();
        eventModel.setEventName(eventName);
        eventModel.setEventCallBack(eventCallBack);
        eventList.add(eventModel);
        return true;
    }

    @Override
    public boolean delEvent(String eventName) throws EventException {
        if (StringUtils.isBlank(eventName)) {
            return false;
        }

        EventModel delEventModel = null;
        for (EventModel event : eventList) {
            if (eventName.equals(event.getEventName())) {
                delEventModel = event;
                break;
            }
        }

        if (delEventModel != null) {
            eventList.remove(delEventModel);
            return true;
        }

        return false;
    }
}
