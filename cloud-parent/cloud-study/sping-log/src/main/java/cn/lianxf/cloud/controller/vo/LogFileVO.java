package cn.lianxf.cloud.controller.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @className LogFileVO
 * @description 日志文件
 * @date 2021/9/10 下午10:40
 * @author little
 * @version 1.0.0
 */
@Data
public class LogFileVO implements Serializable {
    private static final long serialVersionUID = -8746027395477982368L;

    private String fileName;

    private String filePath;

    private String fileSize;

    private String updateTime;
}
