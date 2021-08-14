package cn.lianxf.cloud.jpa.service;

import cn.hutool.core.util.StrUtil;
import cn.lianxf.cloud.jpa.entity.SoftProduct;
import cn.lianxf.cloud.jpa.repository.SoftProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @className SoftProductService
 * @description Soft Product Service
 * @date 2021/8/8 下午1:34
 * @author little
 * @version 1.0.0
 */
@AllArgsConstructor
@Service
public class SoftProductService {

    private final SoftProductRepository softProductRepository;

//    public List<SoftProduct> search(final SoftProduct product) {
//        return softProductRepository.findAll((Specification<SoftProduct>) (root, query, cb) -> {
//
//            Predicate stuNameLike = null;
//            if (null != product && StrUtil.isNotBlank(product.get)) {
//                // 这里也可以root.get("name").as(String.class)这种方式来强转泛型类型
//                stuNameLike = cb.like(root.<String> get("name"), "%" + student.getName() + "%");
//            }
//
//            Predicate clazzNameLike = null;
//            if(null != student && null != student.getClazz() && !StringUtils.isEmpty(student.getClazz().getName())) {
//                clazzNameLike = cb.like(root.<String> get("clazz").<String> get("name"), "%" + student.getClazz().getName() + "%");
//            }
//
//            if(null != stuNameLike) query.where(stuNameLike);
//            if(null != clazzNameLike) query.where(clazzNameLike);
//            return null;
//        });
//    }
}
