package cn.ljava.spring.dynamicProxy.demo02;

import cn.ljava.spring.staticProxy.demo2.UserService;
import cn.ljava.spring.staticProxy.demo2.UserServiceImpl;

/**
 * @Description: 动态代理调用
 * @Author: Liuys
 * @CreateDate: 2021/7/7 13:54
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserService userService = new UserServiceImpl();
        //代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //设置要代理的对象，就是要代理userService,去增强UserServiceImpl类的功能
        pih.setTarget(userService);
        //代理类不存在，就创建
        UserService proxy = (UserService) pih.getProxy();
        //代理去执行方法
        proxy.add();
    }
}
