package com.hzau.swaggerdemo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName Commonresult
 * @Description TODO
 * @Author yueyiming
 * @Date 2023/3/22 16:10
 * @Version 1.0
 * https://blog.csdn.net/hzau_itdog
 **/
@ApiModel(value = "同一返回前端的数据定义")
public class CommonResult<T> {
    private ResultState state;
    private String message;
    private T data;

    public CommonResult(ResultState state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    @ApiModelProperty(value = "信息",example="操作成功" )
    public String getMessage() {
        return message;
    }
    @ApiModelProperty(value = "状态码",dataType = "java.lang.Long",example="200" )
    public Long getCode() {
        return state.getCode();
    }
    @ApiModelProperty(value = "是否成功",dataType = "java.lang.Boolean",example="true" )
    public boolean isSuccess() {
        return state.getCode().longValue() == 200L;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @ApiModelProperty(value = "返回的数据" )
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
