package com.example.captchademo;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.lang.Console;

public class CaptchTest {
    public static void main(String[] args) {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
//ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
//图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("D:/Note/spring_study/back/demo/captcha-demo/src/test/java/" +
                "com/example/captchademo/shear.png");
//验证图形验证码的有效性，返回boolean值
        String a = captcha.getCode();
        boolean ver = captcha.verify(a);
        Console.log(captcha.getCode());
        Console.log(ver);

    }
    public static void main1(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

//图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("D:/Note/spring_study/back/demo/captcha-demo/src/test/java/" +
                "com/example/captchademo/line.png");
//输出code
        Console.log(lineCaptcha.getCode());
//验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("1234");
//
////重新生成验证码
//        lineCaptcha.createCode();
//        lineCaptcha.write("./line.png");
////新的验证码
//        Console.log(lineCaptcha.getCode());
////验证图形验证码的有效性，返回boolean值
//        lineCaptcha.verify("1234");

    }
}
