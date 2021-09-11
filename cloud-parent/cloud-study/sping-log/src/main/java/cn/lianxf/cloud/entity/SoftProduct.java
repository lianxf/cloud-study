package cn.lianxf.cloud.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @className SoftProduct
 * @description Soft Product
 * @date 2021/9/10 下午10:13
 * @author little
 * @version 1.0.0
 */
@Data
@TableName(value = "T_SOFT_PRODUCT")
public class SoftProduct implements Serializable {
    private static final long serialVersionUID = -5141180375569331778L;

    @TableId("ID")
    private String id;

    @TableField("FLOW_INST_ID")
    private String flowInstId;

    @TableField("MATERIAL_CODE")
    private String materialCode;

    @TableField("ORDER_MODEL")
    private String orderModel;

    @TableField("PRODUCT_NAME")
    private String productName;

    @TableField("PRODUCT_VERSION")
    private String productVersion;

    @TableField("ACTIVITY_ID")
    private String activityId;
}
