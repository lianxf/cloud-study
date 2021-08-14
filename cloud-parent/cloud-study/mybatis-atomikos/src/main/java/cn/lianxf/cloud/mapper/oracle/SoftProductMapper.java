package cn.lianxf.cloud.mapper.oracle;

import cn.lianxf.cloud.entity.oracle.SoftProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author little
 * @since 2021-08-11
 */
@Mapper
public interface SoftProductMapper extends BaseMapper<SoftProduct> {

    int insertProduct(SoftProduct product);

    List<SoftProduct> findByFlowInstId(@Param("flowInstId")String flowInstId);
}
