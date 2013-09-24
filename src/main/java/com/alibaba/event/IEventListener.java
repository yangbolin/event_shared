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
 * ��IEventListener.java��ʵ���������¼������ߵĽӿ�
 * 
 * һ���¼����Ա���������߼�����һ�������߿��Լ�������¼�
 * </pre>
 * 
 * @author yangbolin Sep 24, 2013 7:59:13 PM
 */
public interface IEventListener {

    /**
     * ���¼�������ע��һ���¼��Լ���Ӧ�Ļص�
     * 
     * @param eventName �¼�����
     * @param eventCallBack �¼��Ļص�
     * @throws EventException �¼����쳣
     */
    public void addEvent(String eventName, IEventCallBack eventCallBack) throws EventException;

    /**
     * ɾ�������߼�����һ���¼�
     * 
     * @param eventName �¼�����
     * @throws EventException �¼����쳣
     */
    public void delEvent(String eventName) throws EventException;
}
