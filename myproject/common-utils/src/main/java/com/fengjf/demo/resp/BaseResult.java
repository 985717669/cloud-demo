package com.fengjf.demo.resp;

/**
 * 错误码
 * <p>
 * 定义规范：
 * <p>
 * 服务端口号_错误码
 *
 * @author xiaoz
 */

public enum BaseResult implements IRet {
    //公共错误
    SUCCESS("200", "操作成功!"),
    ERROR("400", "操作失败"),
    PARAMETER_ERROR("400", "参数错误"),
    NOT_FOUND("404", "内容不存在");


    private final String code;
    private final String message;

    BaseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
