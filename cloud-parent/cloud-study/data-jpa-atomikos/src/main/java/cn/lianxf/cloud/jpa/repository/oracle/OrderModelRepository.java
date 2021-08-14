package cn.lianxf.cloud.jpa.repository.oracle;

import cn.lianxf.cloud.jpa.entity.oracle.OrderModel;
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
public interface OrderModelRepository extends JpaRepository<OrderModel, String>, JpaSpecificationExecutor<OrderModel> {


}
