package com.example.springdemo3.enums;



public enum ResultStatus {
    // 返回状态
    SUCCESS(200),
    FAIL(-2),
    UNLOGIN(-1),
    ;

    private int code;
    ResultStatus(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}

