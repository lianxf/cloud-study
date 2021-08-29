package cn.lianxf.arthas.boot.aop;

import cn.lianxf.arthas.boot.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @className ApproveAspect
 * @description 测试切面
 * @date 2021/6/14 下午3:45
 * @author little
 * @version 1.0.0
 */
@Slf4j
@Aspect
@Component
public class ApproveAspect {

    @Autowired
    private BalanceService balanceService;

    @Pointcut("@annotation(cn.lianxf.arthas.boot.aop.Approve)")
    public void approve(){}


    @Transactional(rollbackFor = Exception.class)
    @Around(value = "approve()")
    public Object arroundaApprove(ProceedingJoinPoint pjp) throws Throwable{
        Object result = null;
        try {
            result = pjp.proceed();
            balanceService.updateAll();
        }catch (Throwable e){
            log.error("approve aspect execute error, error message:{}", e.getMessage());
            throw e;
        }

        return result;
    }

}
