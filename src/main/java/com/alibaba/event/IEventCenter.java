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
 * ��IEventCenter.java��ʵ���������¼����ĵĽӿ�
 * 
 * �ͻ��˿��Զ����Լ����¼����ģ����Ƶ�ʱ����Ҫʵ������ӿ� 
 * </pre>
 * 
 * @author yangbolin Sep 24, 2013 9:18:42 PM
 */
public interface IEventCenter {
    /**
     * �¼��ķ���
     * @param eventName �¼�����
     * @param eventDTO  �����¼�ʱ�����ݴ������
     */
    public void publish(String eventName, EventDTO eventDTO);
    /**
     * �¼��ķ���
     * @param eventName �¼�����
     */
    public void publish(String eventName);
}
