package cn.lianxf.cloud.repository;

import cn.lianxf.cloud.entity.SoftProduct;
import cn.lianxf.cloud.entity.ValidationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @className ValidationConfigRepository
 * @description 校验配置
 * @date 2021/9/8 下午8:43
 * @author little
 * @version 1.0.0
 */
@Repository
public interface ValidationConfigRepository extends JpaRepository<ValidationConfig, Long>, JpaSpecificationExecutor<ValidationConfig> {

    /**
     * <p> Description: 通过key查询</p>
     * @author little
     * @date 下午8:58 2021/9/8
     * @param keyName 唯一标识
     * @return cn.lianxf.cloud.entity.ValidationConfig
     */
    ValidationConfig findByKeyName(String keyName);
}
