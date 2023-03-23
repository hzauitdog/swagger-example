package com.hzau.swaggerdemo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author yueyiming
 * @Date 2023/3/22 16:18
 * @Version 1.0
 * https://blog.csdn.net/hzau_itdog
 **/
@Data
@ApiModel(value = "用户信息")
public class MyUser {
    @ApiModelProperty(value = "用户名",example="yym" )
    private String userName;
    @ApiModelProperty(value = "邮箱",example="yym@google.com")
    private String email;
    @ApiModelProperty(value = "年龄",example="18")
    private Integer age;
    @ApiModelProperty(value = "性别",example="男")
    private String sex;
    @ApiModelProperty(value = "创建日期",dataType = "java.lang.String",example="2022-07-10 10:23:52")
//    @JsonFormat(pattern ="yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime createTime;
}
