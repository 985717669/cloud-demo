package com.fengjf.demo.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author fengjf
 * @Date 18-9-29
 * @Desc 返回消息封装
 **/
@Data
public class Message<T> implements Serializable {

    private static final long serialVersionUID = 2953946557905707053L;

    /**
     * 返回码
     */
    private String  code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 接口类型
     */
    private String type;

    /**
     * 返回数据
     */
    private T data;

    public Message() {
        this.code = BaseResult.SUCCESS.getCode();
        this.message = BaseResult.SUCCESS.getMessage();
    }

    public Message(IRet result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    public Message(IRet result, String msg) {
        this(result);
        this.message = msg;
    }

    public Message(IRet result, T data) {
        this(result);
        this.data = data;
    }

    public Message(IRet result, String message, T data) {
        this(result);
        this.message = message;
        this.data = data;
    }

    public Message(Message<?> msg, T data) {
        this.code = msg.getCode();
        this.message = msg.message;
        this.data = data;
    }

    public Message(T data) {
        this();
        this.data =data;
    }

}
