package cn.lianxf.cloud.entity.oracle;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author little
 * @since 2021-08-11
 */
@Data
public class PriceDetail implements Serializable {

    private static final long serialVersionUID = 7592808495206858383L;

    private Long count;

    private String unit;

}
