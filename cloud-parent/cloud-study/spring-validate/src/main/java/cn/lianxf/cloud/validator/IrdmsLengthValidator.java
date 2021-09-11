package cn.lianxf.cloud.validator;

import cn.hutool.core.util.StrUtil;
import cn.lianxf.cloud.anno.IrdmsLength;
import cn.lianxf.cloud.entity.ValidationConfig;
import cn.lianxf.cloud.exception.IrdmsValidationException;
import cn.lianxf.cloud.helper.SpringBeanHelper;
import cn.lianxf.cloud.repository.ValidationConfigRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @className IrdmsLengthValidator
 * @description 自定义长度校验
 * @date 2021/9/8 下午8:34
 * @author little
 * @version 1.0.0
 */
public class IrdmsLengthValidator implements ConstraintValidator<IrdmsLength, String> {

    private IrdmsLength irdmsLength;

    @Override
    public void initialize(IrdmsLength irdmsLength) {
        this.irdmsLength = irdmsLength;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        ValidationConfigRepository repository = SpringBeanHelper.getBean(ValidationConfigRepository.class);
        ValidationConfig config = repository.findByKeyName(this.irdmsLength.key());
        if (config != null) {
            long min = config.getMin() != null && config.getMin() > 0 ? config.getMin() : 0;
            long max = config.getMax() != null && config.getMax() > 0 ? config.getMin() : Long.MAX_VALUE;
            if (StrUtil.isBlank(value) && min > 0) {
                return false;
            }
            if (StrUtil.isNotBlank(value)) {
                if (value.length() < min || value.length() > max) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
