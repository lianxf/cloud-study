package cn.lianxf.cloud.entity.oracle;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author little
 * @since 2021-08-11
 */
@Data
public class SaleModulePrice implements Serializable {

    private static final long serialVersionUID = -6215257859452905531L;

    private String maxPrice;

    private String minPrice;

    private Integer required;

    private List<PriceDetail> details;

}
