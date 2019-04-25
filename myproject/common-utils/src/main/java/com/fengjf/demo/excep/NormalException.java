package com.fengjf.demo.excep;

import com.fengjf.demo.resp.IRet;
import lombok.Data;

/**
 * @Author fengjf
 * @Date 18-10-08
 * @Desc
 **/
@Data
public class NormalException extends RuntimeException{
    private String code;
    private String message;

    public NormalException() {
    }

    public NormalException(IRet iRet) {
        this.code =iRet.getCode();
        this.message = iRet.getMessage();
    }

    public NormalException(IRet iRet, String message){
        this(iRet);
        this.message = message;
    }
}
