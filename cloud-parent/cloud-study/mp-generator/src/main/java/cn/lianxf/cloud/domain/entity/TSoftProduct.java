package cn.lianxf.cloud.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author little
 * @since 2021-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_SOFT_PRODUCT")
public class TSoftProduct extends Model<TSoftProduct> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("CREATED_DATE")
    private LocalDateTime createdDate;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("UPDATED_DATE")
    private LocalDateTime updatedDate;

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

    @TableField("TASK_ID")
    private String taskId;

    private List<TSoftSaleModule> saleModules;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
