package com.example.flow;


import lombok.Data;

@Data
public class PriceContext {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 是否境外购
     */
    private boolean oversea;


}
