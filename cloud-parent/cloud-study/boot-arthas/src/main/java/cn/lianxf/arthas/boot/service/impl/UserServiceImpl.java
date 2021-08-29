package cn.lianxf.arthas.boot.service.impl;

import cn.lianxf.arthas.boot.aop.Approve;
import cn.lianxf.arthas.boot.domain.entity.User;
import cn.lianxf.arthas.boot.mapper.UserMapper;
import cn.lianxf.arthas.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lianxiaofei
 * @since 2021-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Approve
    @Transactional
    @Override
    public User updateAll() {
        User user = new User();
        user.setId("1");
        user.setName("fannn dahuaidan");
        user.insertOrUpdate();
        return user;
    }
}
