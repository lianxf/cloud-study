package cn.lianxf.cloud.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPriceDetail is a Querydsl query type for PriceDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPriceDetail extends EntityPathBase<PriceDetail> {

    private static final long serialVersionUID = -1112784530L;

    public static final QPriceDetail priceDetail = new QPriceDetail("priceDetail");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Long> count = createNumber("count", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final BooleanPath deleted = createBoolean("deleted");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath unit = createString("unit");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QPriceDetail(String variable) {
        super(PriceDetail.class, forVariable(variable));
    }

    public QPriceDetail(Path<? extends PriceDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPriceDetail(PathMetadata metadata) {
        super(PriceDetail.class, metadata);
    }

}

