package cn.ljava.spring.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Description: AfterLog 取到返回值后的日志
 * @Author: Liuys
 * @CreateDate: 2021/7/7 17:11
 * @Version: 1.0
 */
public class AfterLog implements AfterReturningAdvice {
    /***
     *
     * @param returnValue  返回结果
     * @param method
     * @param objects
     * @param o1
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+ method.getName()+"方法，返回结果为："+ returnValue);
    }
}
