package com.bluemsun.common.entitys;

import java.sql.Date;

/**
 * @ClassName: Message
 * @Description: 留言的实体类
 * @author Kyrie Irving
 * @date 2017年8月7日 下午2:46:41
 */
public class Message {
	private String id;

	private String userId;

	private String previousMessageId;

	private String messageContent;

	private Date messageTime;

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPreviousMessageId() {
		return previousMessageId;
	}

	public void setPreviousMessageId(String previousMessageId) {
		this.previousMessageId = previousMessageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

}