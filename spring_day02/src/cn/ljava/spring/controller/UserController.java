package cn.ljava.spring.controller;

import cn.ljava.spring.Service.UserService;
import cn.ljava.spring.Service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/1 17:35
 * @Version: 1.0
 */
public class UserController {
    @Test
    public void testMethod(){
        UserService userService = new UserServiceImpl();
        //userService.setUserDao();
        userService.add();
    }
}
