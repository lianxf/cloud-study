package cn.lianxf.cloud.entity;

import cn.lianxf.cloud.anno.IrdmsLength;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @className SoftProduct
 * @description 软件产品信息
 * @date 2021/7/31 上午11:26
 * @author little
 * @version 1.0.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SoftProduct extends BaseEntity{
    private static final long serialVersionUID = 1876412166437817720L;

    @NotBlank(message = "product can not empty")
    private String productName;

    @IrdmsLength(key = "productVersion")
    private String productVersion;

    private String materialCode;

    private String orderModel;

    @Valid
    @NotNull
    private List<SoftSaleModule> saleModules;

    private String flowInstId;

    private String taskId;

}
