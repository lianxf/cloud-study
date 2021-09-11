package cn.lianxf.cloud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @className SoftSaleModule
 * @description 软件产品销售项信息
 * @date 2021/7/31 上午11:30
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SoftSaleModule extends BaseEntity {
    private static final long serialVersionUID = -5158698636915217220L;

    @NotBlank
    @JsonProperty("id")
    private String hicooId;

    private List<String> dependencies;

    private List<SaleModuleUnit> units;

    @Valid
    @NotNull
    private SaleModulePrice price;

}
