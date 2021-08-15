package cn.lianxf.cloud.jpa.controller;

import cn.lianxf.cloud.jpa.entity.mysql.SaleModule;
import cn.lianxf.cloud.jpa.entity.oracle.OrderModel;
import cn.lianxf.cloud.jpa.repository.mysql.SaleModelRepository;
import cn.lianxf.cloud.jpa.repository.oracle.OrderModelRepository;
import cn.lianxf.cloud.jpa.service.mysql.SaleModuleService;
import cn.lianxf.cloud.jpa.service.oracle.OrderModelSerivce;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

    private final OrderModelSerivce orderModelSerivce;

    private final SaleModuleService saleModuleService;

    @Transactional(rollbackFor = Exception.class,
            transactionManager = "jtaTransactionManager")
    @GetMapping("/test")
    public String test(){
        saleModuleService.save(SaleModule.builder().count(1)
                .deleted(false).build());
        orderModelSerivce.save(OrderModel.builder()
                .deleted(false).build());
        return "ok";
    }

    @GetMapping("/test1")
    public String test1(){
        orderModelSerivce.save(OrderModel.builder()
                .deleted(false).build());
        saleModuleService.save(SaleModule.builder().count(1)
                .deleted(false).build());
        System.out.println(1/0);
        return "ok";
    }

    @Transactional(rollbackFor = Exception.class, transactionManager = "jtaTransactionManager")
    @GetMapping("/test2")
    public String test2(){
        orderModelSerivce.save(OrderModel.builder()
                .deleted(false).build());
        saleModuleService.save(SaleModule.builder().count(1)
                .deleted(false).build());
        System.out.println(1/0);
        return "ok";
    }

}
