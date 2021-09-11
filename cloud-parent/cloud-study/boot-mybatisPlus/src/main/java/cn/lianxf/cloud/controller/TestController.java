package cn.lianxf.cloud.controller;

import cn.lianxf.cloud.entity.SoftProduct;
import cn.lianxf.cloud.mapper.SoftProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className TestController
 * @description 测试
 * @date 2021/9/10 下午9:48
 * @author little
 * @version 1.0.0
 */
@AllArgsConstructor
@RestController
public class TestController {

    private final SoftProductMapper softProductMapper;

    @PostMapping("/save")
    public String save(@RequestBody SoftProduct product) {
        softProductMapper.insert(product);
        return "ok";
    }


    @GetMapping("/findByFlowInstId")
    public List<SoftProduct> findByflowInstId(String flowInstId) {
        return softProductMapper.findByFlowInstId(flowInstId);
    }

}
