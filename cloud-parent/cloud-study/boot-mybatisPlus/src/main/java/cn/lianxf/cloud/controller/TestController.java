package cn.lianxf.cloud.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.lianxf.cloud.entity.SiteTree;
import cn.lianxf.cloud.entity.SoftProduct;
import cn.lianxf.cloud.mapper.MeaSiteMapper;
import cn.lianxf.cloud.mapper.SoftProductMapper;
import cn.lianxf.cloud.util.MapUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    private final MeaSiteMapper meaSiteMapper;

    @PostMapping("/save")
    public String save(@RequestBody SoftProduct product) {
        softProductMapper.insert(product);
        return "ok";
    }


    @GetMapping("/findByFlowInstId")
    public List<SoftProduct> findByflowInstId(String flowInstId) {
        return softProductMapper.findByFlowInstId(flowInstId);
    }

    @GetMapping("/site/tree")
    public List<SiteTree> siteTree() {
        List<SiteTree> tree = meaSiteMapper.tree();
        Map<Long, List<SiteTree>> map = MapUtils.group(tree, SiteTree::getParentId);
        List<SiteTree> rootList = map.get(null);
        if (CollUtil.isNotEmpty(rootList)) {
            rootList.forEach(root -> setChildren(root, map));
        }
        return rootList;
    }

    private void setChildren(SiteTree root, Map<Long, List<SiteTree>> map) {
        if (map.containsKey(root.getId())) {
            root.setChildren(map.get(root.getId()));
            if (CollUtil.isNotEmpty(root.getChildren())) {
                root.getChildren().forEach(node -> setChildren(node, map));
            }
        }

    }
}
