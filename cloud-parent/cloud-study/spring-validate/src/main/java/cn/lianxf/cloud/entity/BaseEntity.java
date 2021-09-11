package cn.lianxf.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @className BaseEntity
 * @description Bae Entity
 * @date 2021/8/8 上午11:51
 * @author little
 * @version 1.0.0
 */

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4528351520491177952L;

    @JsonIgnore
    protected String id;

    @JsonIgnore
    protected Date createdDate;

    @JsonIgnore
    protected Date updatedDate;

    @JsonIgnore
    protected Boolean deleted = false;
}
