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
public class SoftSaleModule implements Serializable {

    private static final long serialVersionUID = 2545617327797496520L;

    private String id;

    private String priceId;

    private List<String> dependencies;

    private List<SaleModuleUnit> units;

    private SaleModulePrice price;

    private Boolean required;

}
