package cn.lianxf.arthas.boot.service;

import cn.lianxf.arthas.boot.domain.entity.Balance;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lianxiaofei
 * @since 2021-07-03
 */
public interface BalanceService extends IService<Balance> {


    void updateAll();
}
