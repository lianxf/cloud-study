package cn.lianxf.cloud.domain.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("T_SR_GH_TABLE")
public class TSrGhTable extends Model<TSrGhTable> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private BigDecimal id;

    @TableField("PROCESSINSTANCEID")
    private String processinstanceid;

    @TableField("WF_FLOWSTATUS")
    private String wfFlowstatus;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
