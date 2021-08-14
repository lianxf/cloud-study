package cn.lianxf.cloud.jpa.entity;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @className UnitBean
 * @description 单位
 * @date 2021/7/31 下午12:40
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_sale_module_unit")
@SQLDelete(sql="update t_sale_module_unit set deleted = 1 where id = ?")
public class SaleModuleUnit extends BaseEntity {
    private static final long serialVersionUID = 3108985669463401719L;

    private String unitName;

    private String unitDesc;
}
