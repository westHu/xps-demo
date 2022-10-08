package com.example.disruptor;

import com.lmax.disruptor.EventFactory;

public class DisruptorEventFactory implements EventFactory<DisruptorMessageModel> {

    @Override
    public DisruptorMessageModel newInstance() {
        return new DisruptorMessageModel();
    }

}