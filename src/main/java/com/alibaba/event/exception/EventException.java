/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.exception;

/**
 * 类EventException.java的实现描述：事件的异常类 
 * @author yangbolin Sep 24, 2013 7:45:30 PM
 */
public class EventException extends Exception {

    private static final long serialVersionUID = -1993115658850646104L;
    
    public EventException() {
        super();
    }
    
    public EventException(String message) {
        super(message);
    }
    
    public EventException(String message, Throwable cause) {
        super((cause instanceof EventException) ? message + ":"
                + cause.getLocalizedMessage() : message,
                (cause instanceof EventException) ? cause.getCause()
                        : cause);
    }
    
    public EventException(Throwable cause) {
        super((cause instanceof EventException) ? cause.getCause() : cause);
    }
}
