package cn.lianxf.cloud.mapper;

import cn.lianxf.cloud.entity.SoftProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className SoftProductMapper
 * @description soft product mapper
 * @date 2021/9/10 下午10:16
 * @author little
 * @version 1.0.0
 */
@Mapper
public interface SoftProductMapper extends BaseMapper<SoftProduct> {

    int insertProduct(SoftProduct product);

    List<SoftProduct> findByFlowInstId(@Param("flowInstId")String flowInstId);
}
