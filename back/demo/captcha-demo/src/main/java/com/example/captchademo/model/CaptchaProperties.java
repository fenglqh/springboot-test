package com.example.captchademo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@ConfigurationProperties(prefix = "captcha")
@Data
public class CaptchaProperties {
    private Integer width;
    private Integer height;
//    private Map<String,String> session;
    private Session session;
    @Data
    public static class Session{
        private String key;
        private String date;
        private Integer timeout;
    }
}
