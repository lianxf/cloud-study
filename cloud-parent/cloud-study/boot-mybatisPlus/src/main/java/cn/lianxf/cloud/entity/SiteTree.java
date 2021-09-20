package cn.lianxf.cloud.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @className SiteTree
 * @description 显示位置树
 * @date 2021/9/19 上午11:23
 * @author little
 * @version 1.0.0
 */
@Data
public class SiteTree implements Serializable {

    private static final long serialVersionUID = 2338127684581417524L;
    private Long id;

    private Long parentId;

    private String name;

    private String path;

    private Long priority;

    private LocalDateTime modifiedTime;

    private Integer level;

    private List<SiteTree> children;
}
