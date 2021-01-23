package com.leo.zu.fallback;

import com.leo.zu.entities.CommonResult;
import com.leo.zu.entities.User;
import com.leo.zu.feign.AnalysisService;
import com.leo.zu.request.UserBean;
import org.springframework.stereotype.Component;

/**
 * @author leo-zu
 * @create 2021-01-23 16:17
 */
@Component
public class AnalysisFallbackService implements AnalysisService {
    /**
     * 登录超时
     * @param userBean
     * @return
     */
    @Override
    public CommonResult getUsersByNameAndPassword(UserBean userBean) {
        String result = "-----AnalysisFallbackService fall back-getUsersByNameAndPassword , (┬＿┬)";
        return new CommonResult(400,"登录超时",result);
    }

    @Override
    public CommonResult getUserById(String id) {
        return null;
    }
}
