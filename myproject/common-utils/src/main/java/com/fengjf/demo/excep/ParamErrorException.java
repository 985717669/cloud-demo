package com.fengjf.demo.excep;

import lombok.Data;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

/**
 * @Author fengjf
 * @Date 18-9-30
 * @Desc
 **/
@Data
public class ParamErrorException extends BindException {
    private int code;
    private String message;

    public ParamErrorException(BindingResult bindingResult) {
        super(bindingResult);
    }

    public ParamErrorException(Object target, String objectName) {
        super(target, objectName);
    }
}
