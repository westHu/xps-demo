package com.example.flow;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 初始化参数检查组件
 */
@Slf4j
@Component("checkCmp")
public class CheckCmp extends NodeComponent {


    @Override
    public void process() throws Exception {
        //拿到请求参数
        String req = this.getSlot().getRequestData();
        log.info("req={}", req);
        /***这里Mock参数验证过程***/
        log.info("参数验证完成");
    }
}
