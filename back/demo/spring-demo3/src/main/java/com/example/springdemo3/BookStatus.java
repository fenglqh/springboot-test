package com.example.springdemo3;

import java.util.HashMap;

public enum BookStatus {
    DELETE(0, "已删除"),
    NORMAL(1, "可借阅"),
    FORBIDDEN(2,"不可借阅"),
    ;

    // 有哪些属性
    private String desc;
    private Integer code;

//    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private  BookStatus(Integer code,String desc) {
        this.desc = desc;
        this.code = code;
//        hashMap.put(code, desc);
    }

    public Integer getCode() {
        return code;
    }
    // 返回enum时通过这个方法
    public String getDesc() {
        return desc;
    }

    // 返回枚举项
    public static BookStatus getDescBycode(Integer code) {
        switch (code) {
            case 0: return DELETE;
            case 1: return NORMAL;
            default: return FORBIDDEN;
        }
    }

    // 直接返回描述
    public static String getDesc(Integer code) {
        switch (code) {
            case 0: return DELETE.getDesc();
            case 1: return NORMAL.getDesc();
            default: return FORBIDDEN.getDesc();
        }
    }

    private static HashMap<Integer,String> hashMap = new HashMap<>();
    static {
        for (BookStatus bookStatus : BookStatus.values()) {
            hashMap.put(bookStatus.getCode(),bookStatus.getDesc());
        }
    }
    public static String getDestByHash(Integer code) {
        return hashMap.get(code);
    }

}
