package com.example.remote;

import com.example.remote.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "openFeign-provider")
public interface OpenFeignService {

    /**
     * 参数默认是@RequestBody标注的，如果通过POJO表单传参的，使用@SpringQueryMap标注
     */
    @PostMapping("/openfeign/provider/order1")
    String createOrder1(@SpringQueryMap OrderDTO order);

    /**
     * 参数默认是@RequestBody标注的，这里的@RequestBody可以不填
     * 方法名称任意
     */
    @PostMapping("/openfeign/provider/order2")
    String createOrder2(@RequestBody OrderDTO order);


}
