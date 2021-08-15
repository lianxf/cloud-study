package cn.lianxf.cloud.jpa.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.UserTransaction;

/**
 * @className JtaTranscationConfig
 * @description Transcation Config
 * @date 2021/8/15 下午2:09
 * @author little
 * @version 1.0.0
 */
@Configuration
public class JtaTranscationConfig {
    @Primary
    @Bean(name = "jtaTransactionManager")
    public JtaTransactionManager regTransactionManager () {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        UserTransaction userTransaction = new UserTransactionImp();
        return new JtaTransactionManager(userTransaction, userTransactionManager);
    }
}
