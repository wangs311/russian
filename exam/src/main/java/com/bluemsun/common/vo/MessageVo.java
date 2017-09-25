package com.bluemsun.common.vo;

import com.bluemsun.common.entitys.Message;

/**
 * @Description: 留言的扩展类
 * @author: Dongsl161
 * @Date: 2017/8/16 17:48
 */
public class MessageVo extends Message {

    // 扩展一个上一条
    private MessageVo preMessageVo;

    // 扩展一个用户名
    private String userName;

    public MessageVo getPreMessageVo() {
        return preMessageVo;
    }

    public void setPreMessageVo(MessageVo preMessageVo) {
        this.preMessageVo = preMessageVo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
