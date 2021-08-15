package cn.lianxf.cloud.exception;
/**
 * @className ApiClientExecption
 * @description Api Exception
 * @date 2021/8/15 下午5:19
 * @author little
 * @version 1.0.0
 */
public class ApiClientException extends RuntimeException{
    private static final long serialVersionUID = 6710177679119093674L;

    public ApiClientException() {
        super("api client exception");
    }
}
