package cn.lianxf.cloud.entity.oracle;

import cn.lianxf.cloud.handler.SoftSaleModuleHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
public class SoftProduct extends Model<SoftProduct> {

    private static final long serialVersionUID = 1L;

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

    @TableField(value = "SALE_MODULES", typeHandler = SoftSaleModuleHandler.class)
    private List<SoftSaleModule> saleModules;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
