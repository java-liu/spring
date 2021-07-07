package cn.ljava.spring.dynamicProxy.demo02;

import cn.ljava.spring.dynamicProxy.demo01.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 用这个类自动生成代理类，代理任意对象，做到通用性
 * @Author: Liuys
 * @CreateDate: 2021/7/7 13:22
 * @Version: 1.0
 */
public class ProxyInvocationHandler implements InvocationHandler {
    ///被代理的接口
    //private Rent rent;
    //由上面的代理的接口改成代理Object
    private Object target;
    //代理任意类
    public void setTarget(Object target){
        this.target = target;
    }


    /***
     * 生成得到代理类(固定的代码，target是动态的)
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质，就是使用反射机制实现！
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }
    public void log(String msg){
        System.out.println("执行了" + msg +"方法");
    }

}
