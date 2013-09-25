/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.example;

import com.alibaba.event.EventCenter;
import com.alibaba.event.EventDTO;
import com.alibaba.event.EventListener;
import com.alibaba.event.IEventCallBack;
import com.alibaba.event.exception.EventException;
import com.alibaba.event.strategy.TriggerEventStrategyEnum;

/**
 * 类Client.java的实现描述：事件模式的测试类
 * 
 * @author yangbolin Sep 25, 2013 4:29:27 PM
 */
public class Client {

    public static void main(String[] args) {
        /***************************************************
         * 串行触发测试
         ***************************************************/
        System.out.println("============================串行测试==========================");
        EventCenter serialEventCenter = new EventCenter();
        EventListener listener1 = new EventListener();
        EventListener listener2 = new EventListener();
        serialEventCenter.addListener(listener1);
        serialEventCenter.addListener(listener2);

        try {
            listener1.addEvent("EVENT_TEST1", new IEventCallBack() {

                @Override
                public void execute(final EventDTO eventDTO) {
                    System.out.println("Response EVENT_TEST1 Wow");
                }
            });
            listener2.addEvent("EVENT_TEST2", new IEventCallBack() {

                @Override
                public void execute(final EventDTO eventDTO) {
                    System.out.println("Response EVENT_TEST2 Wow");
                    BucEventDTO bucEventDTO = (BucEventDTO) eventDTO;
                    System.out.println("loginid=" + bucEventDTO.getLoginId());
                    System.out.println("passwd=" + bucEventDTO.getPasswd());
                }
            });
        } catch (EventException e) {
            e.printStackTrace();
        }

        serialEventCenter.publish("EVENT_TEST1");
        BucEventDTO bucEventDTO = new BucEventDTO();
        bucEventDTO.setLoginId("nuaayangbolin");
        bucEventDTO.setPasswd("1111111111");
        serialEventCenter.publish("EVENT_TEST2", bucEventDTO);
        System.out.println("============================串行测试==========================");

        /******************************************************
         * 并发测试
         ******************************************************/
        System.out.println("============================并发测试==========================");
        EventCenter concurrentEventCenter = new EventCenter();
        concurrentEventCenter.setEventTriggerStrategy(TriggerEventStrategyEnum.CONCURRENT.getValue());
        concurrentEventCenter.addListener(listener1);
        concurrentEventCenter.addListener(listener2);
        concurrentEventCenter.publish("EVENT_TEST1");
        concurrentEventCenter.publish("EVENT_TEST2", bucEventDTO);
    }
}
