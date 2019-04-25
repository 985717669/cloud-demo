package com.fengjf.demo.excep;

import com.fengjf.demo.resp.BaseResult;
import com.fengjf.demo.resp.RespBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @Author fengjf
 * @Date 18-9-29
 * @Desc 全局异常处理
 **/
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * 通用异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> error(Exception e) {
        logger.error(BaseResult.ERROR, e);
        return RespBuilder.build(BaseResult.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 参数错误异常
     */
    @ExceptionHandler(ParamErrorException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ParamErrorException(ParamErrorException e) {
        logger.error(BaseResult.ERROR, e);
        List<ObjectError> allErrors = e.getAllErrors();
        String messages = getMessages(allErrors);
        return RespBuilder.build(BaseResult.PARAMETER_ERROR, messages, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 一般错误
     */
    @ExceptionHandler(NormalException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> NormalException(NormalException e) {
        logger.error(BaseResult.ERROR, e);
        return RespBuilder.build(e.getCode(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * 参数错误消息拼接
     */
    public String getMessages(List<ObjectError> allErrors) {
        StringBuffer sb = new StringBuffer();
        for (ObjectError allError : allErrors) {
            String defaultMessage = allError.getDefaultMessage();
            sb.append(defaultMessage + ", ");
        }
        String messages = sb.toString();
        int i = messages.lastIndexOf(",");
        messages = messages.substring(0, i) + ";";

        return messages;
    }

    /**
     * 重写MethodArgumentNotValidException 参数校验
     *=
     */
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> allErrors = result.getAllErrors();
        String messages = getMessages(allErrors);
        logger.error(messages);
        return RespBuilder.build(BaseResult.PARAMETER_ERROR, messages, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
