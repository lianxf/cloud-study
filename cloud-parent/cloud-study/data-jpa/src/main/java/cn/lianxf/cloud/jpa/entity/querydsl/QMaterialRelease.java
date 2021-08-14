package cn.lianxf.cloud.jpa.entity.querydsl;

import cn.lianxf.cloud.jpa.entity.MaterialRelease;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QMaterialRelease is a Querydsl query type for MaterialRelease
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaterialRelease extends EntityPathBase<MaterialRelease> {

    private static final long serialVersionUID = 292003156L;

    public static final QMaterialRelease materialRelease = new QMaterialRelease("materialRelease");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath materialCode = createString("materialCode");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public QMaterialRelease(String variable) {
        super(MaterialRelease.class, forVariable(variable));
    }

    public QMaterialRelease(Path<? extends MaterialRelease> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterialRelease(PathMetadata metadata) {
        super(MaterialRelease.class, metadata);
    }

}

