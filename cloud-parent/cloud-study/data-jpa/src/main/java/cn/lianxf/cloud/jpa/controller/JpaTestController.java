package cn.lianxf.cloud.jpa.controller;

import cn.lianxf.cloud.jpa.controller.vo.MaterialReleaseVO;
import cn.lianxf.cloud.jpa.entity.QMaterialRelease;
import cn.lianxf.cloud.jpa.entity.QSoftProduct;
import cn.lianxf.cloud.jpa.entity.SoftProduct;
import cn.lianxf.cloud.jpa.repository.SoftProductRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

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

    private final SoftProductRepository softProductRepository;

    private final EntityManager em;

    @PostMapping("/save")
    public SoftProduct save(@RequestBody SoftProduct product) {
        SoftProduct save = softProductRepository.save(product);
        return save;
    }

    @PostMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public SoftProduct update(@RequestBody SoftProduct product) {
        int count = softProductRepository.deleteByFlowInstId(product.getFlowInstId());
        SoftProduct save = softProductRepository.save(product);
        return save;
    }

    @GetMapping("/list")
    public List<SoftProduct> list(@RequestParam String flowInstId, @RequestParam String taskId) {
        return softProductRepository.findByFlowInstIdAndTaskId(flowInstId, taskId);
    }

    @GetMapping("/material")
    public List<MaterialReleaseVO> material(@RequestParam String flowInstId) {
        List<MaterialReleaseVO> list = softProductRepository.materialList(flowInstId);
        return list;
    }

    @GetMapping("/material2")
    public Object material2(@RequestParam String flowInstId) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        JPAQuery<Tuple> jpaQuery = queryFactory.select(QSoftProduct.softProduct, QMaterialRelease.materialRelease)
                .from(QSoftProduct.softProduct)
                .leftJoin(QMaterialRelease.materialRelease)
                .on(QSoftProduct.softProduct.materialCode.eq(QMaterialRelease.materialRelease.materialCode));
        // 添加查询条件
        BooleanExpression eq = QSoftProduct.softProduct.flowInstId.eq(flowInstId);
        jpaQuery.where(eq);
        // 拿到结果
        List<Tuple> fetch = jpaQuery.fetch();
         MaterialReleaseVO[] materialReleaseVOS = fetch.toArray(new MaterialReleaseVO[0]);
        return materialReleaseVOS;
    }
}
