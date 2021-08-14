package cn.lianxf.cloud.controller;


import cn.hutool.core.util.IdUtil;
import cn.lianxf.cloud.entity.mysql.User;
import cn.lianxf.cloud.entity.oracle.PriceDetail;
import cn.lianxf.cloud.entity.oracle.SaleModulePrice;
import cn.lianxf.cloud.entity.oracle.SoftProduct;
import cn.lianxf.cloud.entity.oracle.SoftSaleModule;
import cn.lianxf.cloud.mapper.mysql.UserMapper;
import cn.lianxf.cloud.mapper.oracle.SoftProductMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author little
 * @since 2021-08-11
 */
@AllArgsConstructor
@RestController
@RequestMapping("/soft-product")
public class SoftProductController {

    private final SoftProductMapper softProductMapper;

    private final UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/test")
    public String test() {
        SoftProduct product = new SoftProduct();
        product.setId(IdUtil.simpleUUID()).setActivityId("usertask1").setFlowInstId("123123")
                .setMaterialCode("23123")
                .setProductName("1231")
                .setProductVersion("asda");
        SoftSaleModule saleModule = new SoftSaleModule();
        saleModule.setDependencies(Arrays.asList("123", "123"));
        saleModule.setId("123");
        SaleModulePrice price = new SaleModulePrice();
        price.setMaxPrice("123");
        price.setMinPrice("13");
        List<PriceDetail> details = new ArrayList<>();
        PriceDetail detail = new PriceDetail();
        detail.setCount(10L);
        details.add(detail);
        price.setDetails(details);
        saleModule.setPrice(price);
        saleModule.setRequired(false);
        product.setSaleModules(Collections.singletonList(saleModule));
        softProductMapper.insertProduct(product);
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextInt(0, 10000)).setAge(3).setName("nnbaby");
        userMapper.insert(user);
        System.out.println(1/0);
        return "ok";
    }

    @GetMapping("/test1")
    public String test1() {
        SoftProduct product = new SoftProduct();
        product.setId(IdUtil.simpleUUID()).setActivityId("usertask1").setFlowInstId("123123")
                .setMaterialCode("23123")
                .setProductName("1231")
                .setProductVersion("asda");
        SoftSaleModule saleModule = new SoftSaleModule();
        saleModule.setDependencies(Arrays.asList("123", "123"));
        saleModule.setId("123");
        SaleModulePrice price = new SaleModulePrice();
        price.setMaxPrice("123");
        price.setMinPrice("13");
        List<PriceDetail> details = new ArrayList<>();
        PriceDetail detail = new PriceDetail();
        detail.setCount(10L);
        details.add(detail);
        price.setDetails(details);
        saleModule.setPrice(price);
        saleModule.setRequired(false);
        product.setSaleModules(Collections.singletonList(saleModule));
        softProductMapper.insertProduct(product);
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextInt(0, 10000)).setAge(3).setName("nnbaby");
        userMapper.insert(user);
        System.out.println(1 / 0);
        return "ok";
    }
}
