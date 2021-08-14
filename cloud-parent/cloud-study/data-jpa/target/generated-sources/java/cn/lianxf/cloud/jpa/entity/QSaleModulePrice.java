package cn.lianxf.cloud.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSaleModulePrice is a Querydsl query type for SaleModulePrice
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSaleModulePrice extends EntityPathBase<SaleModulePrice> {

    private static final long serialVersionUID = -1363931158L;

    public static final QSaleModulePrice saleModulePrice = new QSaleModulePrice("saleModulePrice");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final ListPath<PriceDetail, QPriceDetail> details = this.<PriceDetail, QPriceDetail>createList("details", PriceDetail.class, QPriceDetail.class, PathInits.DIRECT2);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath maxPrice = createString("maxPrice");

    public final StringPath minPrice = createString("minPrice");

    public final BooleanPath required = createBoolean("required");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QSaleModulePrice(String variable) {
        super(SaleModulePrice.class, forVariable(variable));
    }

    public QSaleModulePrice(Path<? extends SaleModulePrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSaleModulePrice(PathMetadata metadata) {
        super(SaleModulePrice.class, metadata);
    }

}

