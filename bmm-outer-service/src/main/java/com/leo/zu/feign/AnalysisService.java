package com.leo.zu.feign;

import com.leo.zu.entities.CommonResult;
import com.leo.zu.entities.User;
import com.leo.zu.fallback.AnalysisFallbackService;
import com.leo.zu.request.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author leo-zu
 * @create 2021-01-23 16:07
 */
@Component
@FeignClient(value = "BMM-ANALYSIS-SERVICE-LEO",fallback = AnalysisFallbackService.class)
public interface AnalysisService {
    /**
     * 通过用户名和密码获取用户
     * @param userBean
     * @return
     */
    @PostMapping("/login")
    CommonResult getUsersByNameAndPassword(@RequestBody UserBean userBean);

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/getUserById")
    CommonResult getUserById(@RequestParam(value = "id", required = false, defaultValue = "1") String id);
}
