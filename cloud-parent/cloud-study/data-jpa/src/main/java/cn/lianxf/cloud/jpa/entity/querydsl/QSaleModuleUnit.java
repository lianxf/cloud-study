package cn.lianxf.cloud.jpa.entity.querydsl;

import cn.lianxf.cloud.jpa.entity.SaleModuleUnit;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSaleModuleUnit is a Querydsl query type for SaleModuleUnit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSaleModuleUnit extends EntityPathBase<SaleModuleUnit> {

    private static final long serialVersionUID = 1618715331L;

    public static final QSaleModuleUnit saleModuleUnit = new QSaleModuleUnit("saleModuleUnit");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath unitDesc = createString("unitDesc");

    public final StringPath unitName = createString("unitName");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QSaleModuleUnit(String variable) {
        super(SaleModuleUnit.class, forVariable(variable));
    }

    public QSaleModuleUnit(Path<? extends SaleModuleUnit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSaleModuleUnit(PathMetadata metadata) {
        super(SaleModuleUnit.class, metadata);
    }

}

