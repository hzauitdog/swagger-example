package com.hzau.swaggerdemo.vo;

public enum ResultState {
    SUCCESS(200,"操作成功"),
    BAD_REQUEST(400,"参数错误"),
    FAILED(500,"操作失败");
    private Long code;
    private String message;

    ResultState(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
