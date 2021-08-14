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
@TableName("T_SOFT_SALE_MODULE")
public class TSoftSaleModule extends Model<TSoftSaleModule> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("CREATED_DATE")
    private LocalDateTime createdDate;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("UPDATED_DATE")
    private LocalDateTime updatedDate;

    @TableField("HICOO_ID")
    private String hicooId;

    @TableField("PRICE_ID")
    private String priceId;

    @TableField("SOFT_PRODUCT_ID")
    private String softProductId;

    private List<String> dependencies;

    private List<TSaleModuleUnit> units;

    private TSaleModulePrice price;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
