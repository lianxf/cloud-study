package cn.lianxf.cloud.jpa.converter;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.io.Serializable;

/**
 * @className StrListJsonConverter
 * @description 将entity中List<String>类型的属性存储为数据库中的jsonArray字符串
 * @date 2021/7/31 上午11:51
 * @author little
 * @version 1.0.0
 */
@Slf4j
public class StrListJsonConverter implements AttributeConverter<Object,String>, Serializable {
    private static final long serialVersionUID = -1951495779214778549L;

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if (attribute != null) {
            try {
                return JSONUtil.toJsonStr(attribute);
            } catch (Exception e) {
                log.error("[StrListJsonConverter:convertToDatabaseColumn] converter attribute=" + attribute + " error.", e);
                throw new IllegalArgumentException("非法参数：" + attribute.toString());
            }
        }
        return null;
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        if (StrUtil.isNotBlank(dbData)) {
            try {
                return JSONUtil.toList(dbData, String.class);
            } catch (Exception e) {
                log.error("[StrListJsonConverter:convertToEntityAttribute] converter dbData=" + dbData + " error.", e);
            }
        }
        return null;
    }
}
