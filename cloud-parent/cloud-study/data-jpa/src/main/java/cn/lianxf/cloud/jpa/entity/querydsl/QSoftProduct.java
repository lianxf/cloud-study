package cn.lianxf.cloud.jpa.entity.querydsl;

import cn.lianxf.cloud.jpa.entity.SoftProduct;
import cn.lianxf.cloud.jpa.entity.SoftSaleModule;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSoftProduct is a Querydsl query type for SoftProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSoftProduct extends EntityPathBase<SoftProduct> {

    private static final long serialVersionUID = -1060719655L;

    public static final QSoftProduct softProduct = new QSoftProduct("softProduct");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath flowInstId = createString("flowInstId");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath materialCode = createString("materialCode");

    public final StringPath orderModel = createString("orderModel");

    public final StringPath productName = createString("productName");

    public final StringPath productVersion = createString("productVersion");

    public final ListPath<SoftSaleModule, QSoftSaleModule> saleModules = this.<SoftSaleModule, QSoftSaleModule>createList("saleModules", SoftSaleModule.class, QSoftSaleModule.class, PathInits.DIRECT2);

    public final StringPath taskId = createString("taskId");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QSoftProduct(String variable) {
        super(SoftProduct.class, forVariable(variable));
    }

    public QSoftProduct(Path<? extends SoftProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSoftProduct(PathMetadata metadata) {
        super(SoftProduct.class, metadata);
    }

}

