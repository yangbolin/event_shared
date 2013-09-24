/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event;

/**
 * ��IEventCallBack.java��ʵ���������¼��Ļص��ӿ�
 * 
 * @author yangbolin Sep 24, 2013 7:56:48 PM
 */
public interface IEventCallBack {

    /**
     * �¼��ص�����ڷ���
     * 
     * @param eventDTO
     */
    public void execute(EventDTO eventDTO);
}
