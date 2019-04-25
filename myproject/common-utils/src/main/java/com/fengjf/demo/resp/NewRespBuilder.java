package com.fengjf.demo.resp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author 架构大佬
 * @Desc
 **/

public class NewRespBuilder<T> {
    public  static <T> ResponseEntity<Message<T>> build() {
        return build(BaseResult.SUCCESS);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret) {
        return build(ret, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret, HttpStatus status) {
        return new ResponseEntity<>(new Message<T>(ret), status);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret, T data) {
        return build(ret, data, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret, String message, HttpStatus status) {
        return new ResponseEntity<>(new Message<>(ret, message), status);
    }

    public static <T> ResponseEntity<Message<T>> build(IRet ret, T data, HttpStatus status) {
        return new ResponseEntity<>(new Message<>(ret, data), status);
    }

    public static <T> ResponseEntity<Message<T>> build(T body, HttpStatus status) {
        return new ResponseEntity<>(new Message<>(body), status);
    }

    public static <T> ResponseEntity<Message<T>> build(Message<T> message) {
        return build(message, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Message<T>> build(Message<T> message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }

    public static <T> ResponseEntity<Message<T>> build(T data) {
        if (data == null) {
            return build();
        }
        return build(data, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Message<T>> build(String code, String errorMessage, HttpStatus status) {
        Message<T> message = new Message<>();
        message.setCode(code);
        message.setMessage(errorMessage);
        return new ResponseEntity<>(message, status);
    }
}
