package cn.lianxf.cloud.jpa.entity;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @className SoftProduct
 * @description 软件产品信息
 * @date 2021/7/31 上午11:26
 * @author little
 * @version 1.0.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_soft_product")
@SQLDelete(sql="update t_soft_product set deleted = 1 where id = ?")
@Entity
public class SoftProduct extends BaseEntity{
    private static final long serialVersionUID = 1876412166437817720L;

    private String productName;

    private String productVersion;

    private String materialCode;

    private String orderModel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name = "soft_product_id")
    private List<SoftSaleModule> saleModules;

    private String flowInstId;

    private String taskId;

}
