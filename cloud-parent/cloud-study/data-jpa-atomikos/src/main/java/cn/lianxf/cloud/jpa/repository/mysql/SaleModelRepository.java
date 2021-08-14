package cn.lianxf.cloud.jpa.repository.mysql;

import cn.lianxf.cloud.jpa.entity.mysql.SaleModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * @className SoftProductRepository
 * @description 发布信息Repository
 * @date 2021/7/31 下午2:25
 * @author little
 * @version 1.0.0
 */
@Repository
public interface SaleModelRepository extends JpaRepository<SaleModule, Long>, JpaSpecificationExecutor<SaleModule> {


}
