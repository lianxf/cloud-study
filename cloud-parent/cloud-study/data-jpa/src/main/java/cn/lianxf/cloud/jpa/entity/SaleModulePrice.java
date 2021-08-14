package cn.lianxf.cloud.jpa.entity;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @className SaleModulePrice
 * @description 销售项价格
 * @date 2021/8/8 上午11:36
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_sale_module_price")
@SQLDelete(sql="update t_sale_module_price set deleted = 1 where id = ?")
@Entity
public class SaleModulePrice extends BaseEntity {

    private static final long serialVersionUID = -8110666770567112570L;

    private String minPrice;

    private String maxPrice;

    private boolean required;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_module_price_id")
    private List<PriceDetail> details;

}
