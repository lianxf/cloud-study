package cn.lianxf.cloud.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("T_SALE_MODULE_UNIT")
public class TSaleModuleUnit extends Model<TSaleModuleUnit> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("CREATED_DATE")
    private LocalDateTime createdDate;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("UPDATED_DATE")
    private LocalDateTime updatedDate;

    @TableField("UNIT_DESC")
    private String unitDesc;

    @TableField("UNIT_NAME")
    private String unitName;

    @TableField("SALE_MODULE_ID")
    private String saleModuleId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
