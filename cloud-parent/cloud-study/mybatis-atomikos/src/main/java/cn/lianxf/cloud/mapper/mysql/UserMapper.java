package cn.lianxf.cloud.mapper.mysql;

import cn.lianxf.cloud.entity.mysql.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author little
 * @since 2021-08-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
