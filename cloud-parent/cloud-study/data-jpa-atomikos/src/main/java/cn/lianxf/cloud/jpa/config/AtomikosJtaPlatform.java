package cn.lianxf.cloud.jpa.config;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * @className AtomikosJtaPlatform
 * @description atomikos事务管理器
 * @date 2021/8/21 下午6:36
 * @author little
 * @version 1.0.0
 */
public class AtomikosJtaPlatform extends AbstractJtaPlatform {

    private static final long serialVersionUID = 4597689046628434472L;
    /**
     *  事务管理器 atomikos的userTransactionManager
     */
    public static TransactionManager transactionManager;
    /**
     * atomikos的事务管理的相关配置  比如超时时间 等
     */
    public static UserTransaction transaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return transaction;
    }
}
