package com.example.springdemo2.controller;

import com.example.springdemo2.MessageInfo;
import com.example.springdemo2.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stu")
@RestController
public class StudentController {

    // 网络传输给属性赋值是根据set和get方法来的，属性命名得规范不然会出bug
    // 有的时候命名规范，isLogin也可能有坑，不大好避雷
    // 只能说编写完代码得测试一下
    // 数据库也有命名规范
    @RequestMapping(value = "/getStu1")
    public String getStu1(@RequestBody Student student) {
        System.out.println(student.toString());
        System.out.println("已调用后端接口");
        return "student参数：" + student;
    }
//    @RequestMapping("/getStu2")
//    public void getStu2() {
//        // 测试不传数据能不能成功设置id
//        Student s = new Student();
//        s.setId(1);
//        s.setAge(12);
//        s.setName("sty");
//        System.out.println(s.toString());
//    }
    @Autowired
    private MessageInfo messageInfo;
    public void test() {
    }
}
