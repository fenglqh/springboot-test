package com.example.spring_blog.controller;
import com.example.spring_blog.model.Result;
import com.example.spring_blog.model.UserInfo;
import com.example.spring_blog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(String username, String password, HttpServletRequest request) {
        log.info("客户端ip地址:{}", request.getRemoteAddr());
        log.info("login---username:{} , password:{}", username, password);
        // 1. 参数校验
        if (!StringUtils.hasLength(username)) {
            return Result.fail("账号名不能为空");
        }
        if (!StringUtils.hasLength(password)) {
            return Result.fail("密码不能为空");
        }
        UserInfo userInfo = userService.selectByUserAndPwd(username, password);
        if (userInfo == null) {
            return Result.fail("用户不存在或者密码错误");
        }
        return Result.success("");
    }
    @RequestMapping("/register")
    public Result register(String username, String password) {
        log.info("register---username:{} , password:{}", username, password);
        // 1. 参数校验
        if (!StringUtils.hasLength(username)) {
            return Result.fail("账号名不能为空");
        }
        if (!StringUtils.hasLength(password)) {
            return Result.fail("密码不能为空");
        }
        boolean um = username.matches("^[a-zA-Z0-9]+$");
        boolean pm = password.matches("^[a-zA-Z0-9]+$");
        if (!um || !pm) {
            return Result.fail("账号名和密码都只能由字母和数字组成");
        }
        if (userService.selectByUserAndPwd(username, password) != null) {
            return Result.fail("账号名已存在");
        }
        Integer i = userService.insertUser(username, password);
        if (i == null) {
            return Result.fail("注册失败, 请重新尝试，或者反馈给管理员");
        }
        return Result.success("");
    }
}
