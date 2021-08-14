package cn.lianxf.cloud.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @className PriceDetail
 * @description 价格详细信息
 * @date 2021/8/8 上午11:39
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_price_detail")
@SQLDelete(sql="update t_price_detail set deleted = 1 where id = ?")
@Entity
public class PriceDetail extends BaseEntity {
    private static final long serialVersionUID = 4334897727354191363L;

    private long count;

    private String unit;

    private Boolean deleted = false;

}
