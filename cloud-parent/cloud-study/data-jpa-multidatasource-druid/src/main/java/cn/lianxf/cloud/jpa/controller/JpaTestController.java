package cn.lianxf.cloud.jpa.controller;

import cn.lianxf.cloud.jpa.entity.mysql.SaleModule;
import cn.lianxf.cloud.jpa.entity.oracle.OrderModel;
import cn.lianxf.cloud.jpa.repository.mysql.SaleModelRepository;
import cn.lianxf.cloud.jpa.repository.oracle.OrderModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @className JpaTestController
 * @description 测试Jpa的保存和修改
 * @date 2021/7/31 下午2:24
 * @author little
 * @version 1.0.0
 */
@AllArgsConstructor
@RequestMapping("/jpa")
@RestController
public class JpaTestController {

    private final OrderModelRepository orderModelRepository;

    private final SaleModelRepository saleModelRepository;

    @GetMapping("/test")
    public String test(){
        orderModelRepository.save(OrderModel.builder()
                .deleted(false).build());
        saleModelRepository.save(SaleModule.builder().count(1)
                .deleted(false).build());
        return "ok";
    }

}
