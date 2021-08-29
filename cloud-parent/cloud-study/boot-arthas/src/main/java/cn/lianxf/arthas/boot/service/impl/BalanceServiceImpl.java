package cn.lianxf.arthas.boot.service.impl;

import cn.lianxf.arthas.boot.domain.entity.Balance;
import cn.lianxf.arthas.boot.mapper.BalanceMapper;
import cn.lianxf.arthas.boot.service.BalanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lianxiaofei
 * @since 2021-07-03
 */
@Service
public class BalanceServiceImpl extends ServiceImpl<BalanceMapper, Balance> implements BalanceService {

    @Transactional
    @Override
    public void updateAll() {
        Balance balance = new Balance();
        balance.setBalance(new BigDecimal("100.91"));
        balance.setId("1");
        balance.setUserId("126378123871623861237126478126478612784678126378126378126387126387126381");
        balance.insertOrUpdate();
    }
}
