package cn.lianxf.cloud.jpa.entity.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @className SaleModule
 * @description SaleModule
 * @date 2021/8/14 下午5:38
 * @author little
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "t_sale_module")
@Entity
public class SaleModule implements Serializable {
    private static final long serialVersionUID = -4733638390764957041L;

    @Id
    @GeneratedValue(generator = "indentityGenerator", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "required", length = 1)
    private Boolean required;

    @Column(name = "deleted", length = 1)
    private boolean deleted;

    @Column(name = "count", length = 1)
    private int count;


}
