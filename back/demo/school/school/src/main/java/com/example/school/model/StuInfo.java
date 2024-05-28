package com.example.school.model;

import lombok.Data;

@Data
public class StuInfo {
    private Integer Id = 0;
    private String stu;
    private String sname;
    private String grade;
    private String pass;
    private Integer temperature;
    private String message;
}
