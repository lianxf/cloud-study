package cn.lianxf.cloud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @className SaleModulePrice
 * @description 销售项价格
 * @date 2021/8/8 上午11:36
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SaleModulePrice extends BaseEntity {

    private static final long serialVersionUID = -8110666770567112570L;

    @NotBlank
    private String minPrice;

    private String maxPrice;

    private boolean required;

    @Valid
    @NotEmpty
    private List<PriceDetail> details;

}
