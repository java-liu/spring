package cn.ljava;

import cn.ljava.spring.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/7 17:25
 * @Version: 1.0
 */
public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        userService.add();
    }
}
