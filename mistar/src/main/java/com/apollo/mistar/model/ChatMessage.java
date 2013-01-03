package com.apollo.mistar.model;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 31/12/12
 */
@JsonTypeInfo(
        use=JsonTypeInfo.Id.CLASS,
        include=JsonTypeInfo.As.PROPERTY,
        property="@class")
public class ChatMessage implements Serializable{
    String sender;
    String message;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    Date createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChatMessage)) return false;

        ChatMessage that = (ChatMessage) o;

        if (!createdAt.equals(that.createdAt)) return false;
        if (!message.equals(that.message)) return false;
        if (!sender.equals(that.sender)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public int hashCode() {
        int result = sender.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + createdAt.hashCode();
        return result;
    }
}
