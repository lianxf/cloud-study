package cn.lianxf.cloud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @className UnitBean
 * @description 单位
 * @date 2021/7/31 下午12:40
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SaleModuleUnit extends BaseEntity {
    private static final long serialVersionUID = 3108985669463401719L;

    private String unitName;

    private String unitDesc;
}
