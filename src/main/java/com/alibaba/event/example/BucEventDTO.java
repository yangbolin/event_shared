/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.alibaba.event.example;

import com.alibaba.event.EventDTO;

/**
 * 类BucEventDTO.java的实现描述：客户端测试时的数据传输对象
 * 
 * @author yangbolin Sep 25, 2013 9:16:47 PM
 */
public class BucEventDTO extends EventDTO {

    private String loginId;
    private String passwd;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}
