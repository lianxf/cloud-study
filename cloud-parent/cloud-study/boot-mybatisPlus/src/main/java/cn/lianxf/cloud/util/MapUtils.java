package cn.lianxf.cloud.util;

import cn.hutool.core.collection.CollUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @className MapUtils
 * @description map util
 * @date 2021/9/19 上午11:54
 * @author little
 * @version 1.0.0
 */
public class MapUtils {

    /**
     * <p> Description:分组</p>
     * @author little
     * @date 下午6:23 2021/9/19
     * @param list 集合
     * @param mapper key值function
     * @return java.util.Map<K,java.util.List<V>>
     */
    public static <K, V> Map<K, List<V>> group(List<V> list, Function<V, K> mapper) {
        Map<K, List<V>> map = new HashMap<>(256);
        if (CollUtil.isNotEmpty(list)) {
            list.forEach(e -> {
                if (map.containsKey(mapper.apply(e))) {
                    map.get(mapper.apply(e)).add(e);
                } else {
                    map.put(mapper.apply(e), CollUtil.newArrayList(e));
                }
            });
        }
        return map;
    }
}
