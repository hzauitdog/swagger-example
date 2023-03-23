package com.hzau.swaggerdemo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @ClassName MyUserImg
 * @Description TODO
 * @Author yueyiming
 * @Date 2023/3/23 14:36
 * @Version 1.0
 * https://blog.csdn.net/hzau_itdog
 **/
@Data
@ApiModel(value = "用户图片信息")
public class MyUserImg {

    @ApiModelProperty(value = "用户名",example="yym" )
    private String userName;
    @ApiModelProperty(value = "邮箱",example="yym@google.com")
    private String email;
    @ApiModelProperty(value = "年龄",example="18")
    private Integer age;
    @ApiModelProperty(value = "性别",example="男")
    private String sex;
    @ApiModelProperty(value = "创建日期",dataType = "java.lang.String",example="2022-07-10 10:23:52")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private MultipartFile file;
}
