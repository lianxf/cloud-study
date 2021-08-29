package cn.lianxf.cloud.jpa.service.oracle;

import cn.lianxf.cloud.jpa.entity.oracle.OrderModel;
import cn.lianxf.cloud.jpa.repository.oracle.OrderModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @className OrderModelSerivce
 * @description Order Model Service
 * @date 2021/8/15 下午3:52
 * @author little
 * @version 1.0.0
 */
@Transactional(transactionManager = "oracleTransactionManager",
        rollbackFor = Exception.class, propagation = Propagation.NEVER)
@Service
public class OrderModelSerivce {
    @Autowired
    private OrderModelRepository orderModelRepository;

    public void save(OrderModel model) {
        try {
            orderModelRepository.save(model);
        } catch (Exception e) {
            //强制手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
