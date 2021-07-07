package cn.ljava.spring.service.impl;

import cn.ljava.spring.service.UserService;

/**
 * @Description: UserServiceImpl
 * @Author: Liuys
 * @CreateDate: 2021/7/7 16:50
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户");
    }
}
