package cn.lianxf.cloud.mapper;

import cn.lianxf.cloud.entity.MeaSite;
import cn.lianxf.cloud.entity.SiteTree;
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
public interface MeaSiteMapper extends BaseMapper<MeaSite> {

    /**
     * <p> Description:查询显示位置树结构</p>
     * @author little
     * @date 上午11:25 2021/9/19
     * @return java.util.List<cn.lianxf.cloud.entity.SiteTree>
     */
    List<SiteTree> tree();

}
