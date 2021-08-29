package cn.lianxf.cloud.jpa.service.mysql;

import cn.lianxf.cloud.jpa.entity.mysql.SaleModule;
import cn.lianxf.cloud.jpa.repository.mysql.SaleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @className SaleModuleService
 * @description Sale Module Service
 * @date 2021/8/15 下午3:55
 * @author little
 * @version 1.0.0
 */
@Transactional(transactionManager = "mysqlTransactionManager", rollbackFor = Exception.class,
        propagation = Propagation.NEVER)
@Service
public class SaleModuleService {

    @Autowired
    private SaleModelRepository saleModelRepository;


    public void save(SaleModule module) {
        try {
            saleModelRepository.save(module);
        } catch (Exception e) {
            // 强制手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
