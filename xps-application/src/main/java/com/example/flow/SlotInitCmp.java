package com.example.flow;

import com.yomahub.liteflow.core.NodeComponent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Slot初始化组件
 */
@Slf4j
@Component("slotInitCmp")
public class SlotInitCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        log.info("把主要参数冗余到slot里");
    }

    @Override
    public boolean isAccess() {
        return true;
    }
}
