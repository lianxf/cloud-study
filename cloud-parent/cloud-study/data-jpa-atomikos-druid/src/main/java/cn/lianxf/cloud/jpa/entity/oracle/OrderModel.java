package cn.lianxf.cloud.jpa.entity.oracle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @className OrderModel
 * @description OrderModel
 * @date 2021/8/14 下午7:39
 * @author little
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "t_order_model")
@Entity
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 7280796683951745287L;
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    private String id;

    private Boolean required;

    private boolean deleted;

    private int count;

}
