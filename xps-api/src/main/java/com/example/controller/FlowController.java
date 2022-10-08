package com.example.controller;

import com.example.flow.PriceContext;
import com.example.utils.JsonUtil;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FlowController {

    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping(value = "/flow")
    public String flow() {
        try{
            String req = "hi, west!";
            LiteflowResponse response = flowExecutor.execute2Resp("mainChain", req, PriceContext.class);

            PriceContext contextBean = response.getContextBean(PriceContext.class);
            return JsonUtil.objectToString(contextBean);
        }catch (Throwable t){
            t.printStackTrace();
            return "error";
        }
    }
}
