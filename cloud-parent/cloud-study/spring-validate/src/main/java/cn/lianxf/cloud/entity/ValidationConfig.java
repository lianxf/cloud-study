package cn.lianxf.cloud.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @className ValidationConfig
 * @description 校验配置
 * @date 2021/9/8 下午8:43
 * @author little
 * @version 1.0.0
 */
@Data
@Table(name = "T_VALIDATION_CONFIG")
@Entity
public class ValidationConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private Long min;

    private Long max;

    private String keyName;
}
