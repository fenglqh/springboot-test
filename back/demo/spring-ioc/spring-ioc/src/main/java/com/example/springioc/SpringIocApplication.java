package com.example.springioc;

import com.example.springioc.component.UserComponent;
import com.example.springioc.config.UserConfig;
import com.example.springioc.controller.HController;
import com.example.springioc.controller.HelloController;
import com.example.springioc.repo.UserRepo;
import com.example.springioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringIocApplication.class, args);
        UserComponent bean = context.getBean(UserComponent.class);
        bean.doComponent();
        UserService bean1 = context.getBean(UserService.class);
        bean1.doService();
        UserConfig bean2 = context.getBean(UserConfig.class);
        bean2.doConfig();
//        UserRepo bean3 = context.getBean(UserRepo.class);
        UserRepo bean3 = (UserRepo) context.getBean("userRepo");

        bean3.doRepo();
//        context.close();// 这就是关闭进程的方法
    }

    /**
     * 验证spring的ioc机制，也就是控制权反转
     * @param args
     */
    public static void main1(String[] args) {
//        整个应用存储的信息
        ConfigurableApplicationContext run = SpringApplication.run(SpringIocApplication.class, args);
        HelloController bean = run.getBean(HelloController.class);//获取到bean就说明对象创建出来了
        bean.sayHi(); //这是根据类型获取bean
//        HelloController bean = (HelloController) run.getBean("helloController");
//        根据名字获取bean，这个bean的名字是类的小驼峰
        bean.sayHi();
        HelloController bean2 = run.getBean("helloController",HelloController.class);
        bean2.sayHi();
        HController bean3 = (HController) run.getBean("HController");
        bean3.sayHi();


    }


}
