package cn.lianxf.cloud.exception;
/**
 * @className IrdmsValidationException
 * @description 校验异常
 * @date 2021/9/8 下午9:00
 * @author little
 * @version 1.0.0
 */
public class IrdmsValidationException extends RuntimeException{
    private static final long serialVersionUID = -5514023033722536957L;

    public IrdmsValidationException(String message) {
        super(message);
    }
}
