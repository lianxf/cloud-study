package cn.lianxf.cloud.mapper;

import cn.lianxf.cloud.domain.entity.TSoftProduct;
import cn.lianxf.cloud.domain.entity.TSoftSaleModule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TSoftProductMapper extends BaseMapper<TSoftProduct> {

    void updateSoftProductList(@Param("flowInstId")String flowInstId,
                               @Param("activityId")String activityId,
                               @Param("productList")List<TSoftProduct> products);

}
