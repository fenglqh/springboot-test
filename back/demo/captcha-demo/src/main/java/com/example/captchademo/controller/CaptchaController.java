package com.example.captchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.example.captchademo.constant.Constants;
import com.example.captchademo.model.CaptchaProperties;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Slf4j
@RequestMapping("/admin")
@RestController
public class CaptchaController {
//   取配置文件值方式一
//    @ Value("{captcha.width}")
//    private Integer width;

//   方式二，用对象获取
//    private String code1; 不是无状态的，不可以提取
    @Autowired
    private CaptchaProperties captchaProperties;
    @RequestMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight(), 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
//        captcha.write("d:/shear.png");
        //验证图形验证码的有效性，返回boolean值
//        captcha.verify("1234");
//        设置返回类型
        response.setContentType("image/jpeg");
//        禁止缓存
        response.setHeader("Pragma", "No-cache");

        String code = captcha.getCode();
//        将code以用户级别进行存储
        session.setAttribute(captchaProperties.getSession().getKey(), code);
        session.setAttribute(captchaProperties.getSession().getDate(), System.currentTimeMillis());
        ServletOutputStream outputStream = response.getOutputStream();
        captcha.write(outputStream);
        outputStream.close();
        //Servlet的OutputStream记得自行关闭哦！

    }

    @RequestMapping("/check")
    public String checkCaptcha(String code, HttpSession session) {
        // 判断验证码是否有效
        long setTime = (Long) session.getAttribute(captchaProperties.getSession().getDate());
        long curTime = System.currentTimeMillis();
        if ((curTime - setTime) > captchaProperties.getSession().getTimeout()) {
            return "验证码超时";
        }

        log.info("code----------------"+ code);
//        session默认三十分钟有效期
        String code1 = (String)session.getAttribute(Constants.USER_CODE_KEY);
        log.info("code1--------------"+ code1);
        if (code == null || code.length() != 4) {
            return "验证码非法";
        }
        if (!code.equalsIgnoreCase(code1)) {
            return "验证码错误";
        }
        return "";
    }
}
