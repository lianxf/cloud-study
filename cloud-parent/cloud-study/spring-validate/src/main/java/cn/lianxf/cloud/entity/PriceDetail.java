package cn.lianxf.cloud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


/**
 * @className PriceDetail
 * @description 价格详细信息
 * @date 2021/8/8 上午11:39
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PriceDetail extends BaseEntity {
    private static final long serialVersionUID = 4334897727354191363L;

    @NotNull
    private long count;

    private String unit;

    private Boolean deleted = false;

}
