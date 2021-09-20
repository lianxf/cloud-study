package cn.lianxf.cloud.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @className MeaSite
 * @description 显示位置
 * @date 2021/9/19 上午11:20
 * @author little
 * @version 1.0.0
 */
@Data
@TableName("MEA_SITE")
public class MeaSite implements Serializable {
    private static final long serialVersionUID = 4370390842220531895L;

    @TableId("ID")
    private Long id;

    @TableId("PARENT_ID")
    private Long parentId;

    @TableId("NAME")
    private String name;

    @TableId("PATH")
    private String path;

    @TableId("PRIORITY")
    private Long priority;

    @TableId("MODIFIED_TIME")
    private LocalDateTime modifiedTime;

}
