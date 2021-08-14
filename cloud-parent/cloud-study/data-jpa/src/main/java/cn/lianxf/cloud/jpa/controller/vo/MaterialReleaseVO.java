package cn.lianxf.cloud.jpa.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className MaterialReleaseVO
 * @description MaterialReleaseVO
 * @date 2021/8/8 下午1:47
 * @author little
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaterialReleaseVO implements Serializable {

    private static final long serialVersionUID = -8389581259149102318L;
    private String flowInstId;

    private String materialCode;

    private Integer status;
}
