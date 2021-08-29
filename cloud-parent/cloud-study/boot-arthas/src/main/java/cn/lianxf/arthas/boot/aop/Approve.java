package cn.lianxf.arthas.boot.aop;
/**
 * @className Approve
 * @description 测试注解
 * @date 2021/6/14 下午3:52
 * @author little
 * @version 1.0.0
 */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
public @interface Approve {
}
