package com.leo.zu.controller;

import com.leo.zu.entities.CommonResult;
import com.leo.zu.feign.AnalysisService;
import com.leo.zu.request.UserBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author leo-zu
 * @create 2021-01-23 16:25
 */
@RestController
@Slf4j
public class OuterController {
    /**
     * 分析服务
     */
    @Resource
    private AnalysisService analysisService;

    /**
     * 登录
     * @param userBean
     * @return
     */
    @PostMapping("/outer/login")
    @ApiOperation(value = "登录",httpMethod = "POST")
    @HystrixCommand
    public CommonResult login(@RequestBody UserBean userBean){
        return analysisService.getUsersByNameAndPassword(userBean);
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @GetMapping("/outer/getUserById")
    @ApiOperation(value = "获取用户信息",httpMethod = "GET")
    @HystrixCommand
    public CommonResult getUserById(@RequestParam(value = "id", required = false, defaultValue = "1") String id){
        return analysisService.getUserById(id);
    }
}
