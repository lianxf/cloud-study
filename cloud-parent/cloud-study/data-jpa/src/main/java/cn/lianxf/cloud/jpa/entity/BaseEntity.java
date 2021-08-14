package cn.lianxf.cloud.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @className BaseEntity
 * @description Bae Entity
 * @date 2021/8/8 上午11:51
 * @author little
 * @version 1.0.0
 */

@Where(clause = "deleted = 0")
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4528351520491177952L;

    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @JsonIgnore
    protected String id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    protected Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    protected Date updatedDate;

    @JsonIgnore
    protected Boolean deleted = false;
}
