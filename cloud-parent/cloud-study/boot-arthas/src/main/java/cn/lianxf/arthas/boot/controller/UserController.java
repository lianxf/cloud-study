package cn.lianxf.arthas.boot.controller;


import cn.lianxf.arthas.boot.domain.entity.User;
import cn.lianxf.arthas.boot.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lianxiaofei
 * @since 2021-07-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(UserController.class);

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public User test() {
        return userService.updateAll();
    }


    @GetMapping("/test1")
    public String test1() {
        LOG.info("----------------log4j  info----------------");
        LOG.warn("----------------log4j  warn----------------");
        LOG.error("----------------log4j  error----------------");
        log.info("----------------log4j  info----------------");
        log.warn("----------------log4j  warn----------------");
        log.error("----------------log4j  error----------------");
        return "ok";
    }

    @GetMapping("/test2")
    public String test2() {
        throw new RuntimeException("-----------------system error-----------------");
    }

}
