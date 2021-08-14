package cn.lianxf.cloud.jpa.entity;

import cn.hutool.core.date.DatePattern;
import cn.lianxf.cloud.jpa.converter.StrListJsonConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @className SoftSaleModule
 * @description 软件产品销售项信息
 * @date 2021/7/31 上午11:30
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_soft_sale_module")
@Entity
@SQLDelete(sql="update t_soft_sale_module set deleted = 1 where id = ?")
public class SoftSaleModule extends BaseEntity {
    private static final long serialVersionUID = -5158698636915217220L;

    @JsonProperty("id")
    private String hicooId;

    @Convert(converter = StrListJsonConverter.class)
    private List<String> dependencies;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "sale_module_id")
    private List<SaleModuleUnit> units;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "price_id")
    private SaleModulePrice price;

}
