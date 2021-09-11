package cn.lianxf.cloud.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @className MaterialRelease
 * @description 物料发布信息
 * @date 2021/8/8 下午9:22
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MaterialRelease extends BaseEntity{
    private static final long serialVersionUID = -7366092199703816097L;

    private String materialCode;

    private Integer status;
}
