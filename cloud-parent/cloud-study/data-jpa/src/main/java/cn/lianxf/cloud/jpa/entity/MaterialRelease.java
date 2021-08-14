package cn.lianxf.cloud.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @className MaterialRelease
 * @description 物料发布信息
 * @date 2021/8/8 下午9:22
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "t_material_release")
@SQLDelete(sql="update t_material_release set deleted = 1 where id = ?")
@Entity
public class MaterialRelease extends BaseEntity{
    private static final long serialVersionUID = -7366092199703816097L;

    private String materialCode;

    private Integer status;
}
