package cn.lianxf.cloud.anno;

import cn.lianxf.cloud.validator.IrdmsLengthValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @className IrdmsLength
 * @description 自定义长度校验
 * @date 2021/9/8 下午8:20
 * @author little
 * @version 1.0.0
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IrdmsLengthValidator.class})
public @interface IrdmsLength {
    String key();

    String message() default "{org.hibernate.validator.constraints.Length.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
