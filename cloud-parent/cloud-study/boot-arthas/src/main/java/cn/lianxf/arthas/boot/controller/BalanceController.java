package cn.lianxf.arthas.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lianxiaofei
 * @since 2021-07-03
 */
@Controller
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping("/jrebel")
    @ResponseBody
    public String jrebel(){
        return "978231";
    }
}
