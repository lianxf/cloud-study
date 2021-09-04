package cn.lianxf.cloud.guava.event;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @className TestEvent3
 * @description event3
 * @date 2021/9/4 下午9:46
 * @author little
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TestEvent3 extends TestEvent {
    private Integer id;
}
