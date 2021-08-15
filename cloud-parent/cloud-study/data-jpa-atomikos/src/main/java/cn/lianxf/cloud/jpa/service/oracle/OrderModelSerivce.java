package cn.lianxf.cloud.jpa.service.oracle;

import cn.lianxf.cloud.jpa.entity.oracle.OrderModel;
import cn.lianxf.cloud.jpa.repository.oracle.OrderModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className OrderModelSerivce
 * @description Order Model Service
 * @date 2021/8/15 下午3:52
 * @author little
 * @version 1.0.0
 */
@Transactional(transactionManager = "oracleTranscationManager", propagation = Propagation.NEVER)
@Service
public class OrderModelSerivce {
    @Autowired
    private OrderModelRepository orderModelRepository;

    public void save(OrderModel model) {
        orderModelRepository.save(model);
    }
}
