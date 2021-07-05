package cn.ljava.spring.controller;

import cn.ljava.spring.Service.UserService;
import cn.ljava.spring.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/1 17:35
 * @Version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Test
    public void testMethod(){
        /*UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao1(new UserDaoImpl());*/
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        //Resource resource = new ClassPathResource("bean2.xml");
        userService.add();
    }
    @Test
    public void testMethod1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }
}
