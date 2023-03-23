package com.hzau.swaggerdemo.controller;

import com.hzau.swaggerdemo.vo.CommonResult;
import com.hzau.swaggerdemo.vo.MyUser;
import com.hzau.swaggerdemo.vo.ResultState;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yueyiming
 * @Date 2023/3/22 16:08
 * @Version 1.0
 * https://blog.csdn.net/hzau_itdog
 **/
@RestController
@Api(tags = "用户操作api")
public class TestController {

    @ApiOperation(value = "根据用户名查询用户")
    @GetMapping("get/{userName}")
    @ApiImplicitParam(name = "userName", paramType = "path")
    public CommonResult<MyUser> get(@PathVariable("userName") String userName, @ApiParam("年龄") @RequestParam("age") Integer age) {
        MyUser myUser = new MyUser();
        myUser.setAge(age);
        myUser.setEmail("yym@google.com");
        myUser.setSex("男");
        myUser.setUserName(userName);
        myUser.setCreateTime(LocalDateTime.now());
        return new CommonResult<>(ResultState.SUCCESS, "操作成功", myUser);
    }


    @ApiOperation(value = "保存用户")
    @PostMapping("save")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "form"),
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "form"),
            @ApiImplicitParam(name = "age", value = "年龄", paramType = "form"),
            @ApiImplicitParam(name = "sex", value = "性别", paramType = "form"),
            @ApiImplicitParam(name = "createTime", value = "创建日期", paramType = "form")

    })
    public CommonResult<MyUser> save(MyUser myUser) {
        return new CommonResult<>(ResultState.SUCCESS, "操作成功", myUser);
    }


    @ApiOperation(value = "json保存用户")
    @PostMapping("saveJson")
    public CommonResult<MyUser> saveJson(@RequestBody MyUser myUser) {
        return new CommonResult<>(ResultState.SUCCESS, "操作成功", myUser);
    }

}
