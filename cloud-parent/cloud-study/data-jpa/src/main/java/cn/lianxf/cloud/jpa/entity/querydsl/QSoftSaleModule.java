package cn.lianxf.cloud.jpa.entity.querydsl;

import cn.lianxf.cloud.jpa.entity.SaleModuleUnit;
import cn.lianxf.cloud.jpa.entity.SoftSaleModule;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSoftSaleModule is a Querydsl query type for SoftSaleModule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSoftSaleModule extends EntityPathBase<SoftSaleModule> {

    private static final long serialVersionUID = 1362131561L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSoftSaleModule softSaleModule = new QSoftSaleModule("softSaleModule");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final ListPath<String, StringPath> dependencies = this.<String, StringPath>createList("dependencies", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath hicooId = createString("hicooId");

    //inherited
    public final StringPath id = _super.id;

    public final QSaleModulePrice price;

    public final ListPath<SaleModuleUnit, QSaleModuleUnit> units = this.<SaleModuleUnit, QSaleModuleUnit>createList("units", SaleModuleUnit.class, QSaleModuleUnit.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QSoftSaleModule(String variable) {
        this(SoftSaleModule.class, forVariable(variable), INITS);
    }

    public QSoftSaleModule(Path<? extends SoftSaleModule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSoftSaleModule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSoftSaleModule(PathMetadata metadata, PathInits inits) {
        this(SoftSaleModule.class, metadata, inits);
    }

    public QSoftSaleModule(Class<? extends SoftSaleModule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.price = inits.isInitialized("price") ? new QSaleModulePrice(forProperty("price")) : null;
    }

}

