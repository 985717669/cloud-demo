package com.fengjf.demo.resp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author fengjf
 * @Date 18-9-29
 * @Desc
 **/

public class RespBuilder<T> {


    public  static <T> ResponseEntity<Message<T>> build() {
        return build(BaseResult.SUCCESS);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret) {
        return build(ret, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret, HttpStatus status) {
        return new ResponseEntity(new Message<>(ret), status);
    }

    public static <T> ResponseEntity<Message<T>> build(T data) {
        if (data == null) {
            return build();
        }
        return build(data, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> build(IRet ret, String message, HttpStatus status) {
        return new ResponseEntity(new Message<>(ret, message), status);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret, Object data, HttpStatus status) {
        return new ResponseEntity(new Message<>(ret, data), status);
    }

    public static <T> ResponseEntity<Message<T>> build(Object body, HttpStatus status) {
        return new ResponseEntity(new Message<>(body), status);
    }

    public static <T> ResponseEntity<Message<T>> build(Message<?> message) {
        return build(message, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Message<T>> build(Message<?> message, HttpStatus status) {
        return new ResponseEntity(message, status);
    }


    public static <T> ResponseEntity<Message<T>> build(String code, String errorMessage, HttpStatus status) {
        Message<?> message = new Message<>();
        message.setCode(code);
        message.setMessage(errorMessage);
        return new ResponseEntity(message, status);
    }
}
