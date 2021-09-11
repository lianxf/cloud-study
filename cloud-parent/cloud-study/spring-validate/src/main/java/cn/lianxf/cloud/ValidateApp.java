package cn.lianxf.cloud;

import cn.lianxf.cloud.entity.SaleModulePrice;
import cn.lianxf.cloud.entity.SoftProduct;
import cn.lianxf.cloud.entity.SoftSaleModule;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Collections;
import java.util.Set;

/**
 * @className cn.lianxf.cloud.ValidateApp
 * @description 参数校验
 * @date 2021/9/7 下午10:20
 * @author little
 * @version 1.0.0
 */
public class ValidateApp {

    public static void main(String[] args) {
        SoftProduct product = new SoftProduct();
        product.setProductName("122");
        SoftSaleModule module = new SoftSaleModule();
        module.setHicooId("123");
        SaleModulePrice price = new SaleModulePrice();
        price.setMinPrice("123");
//        price.setDetails(Collections.emptyList());
        module.setPrice(price);

        product.setSaleModules(Collections.singletonList(module));
        Set<ConstraintViolation<SoftProduct>> result = Validation.buildDefaultValidatorFactory()
                .getValidator().validate(product);
        // 对结果进行遍历输出
        result.stream()
                .map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue())
                .forEach(System.out::println);

    }
}
