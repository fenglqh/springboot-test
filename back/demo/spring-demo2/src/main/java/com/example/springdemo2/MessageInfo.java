package com.example.springdemo2;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MessageInfo {
    private String from;
    private String to;
    private String say;

}
