package cn.ljava.spring.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/7 17:07
 * @Version: 1.0
 */
public class AopLog implements MethodBeforeAdvice {
    /***
     *
     * @param method 要执行的目标对象的方法
     * @param objects 参数
     * @param o 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+ "的" +method.getName() +"执行了");
    }
}
