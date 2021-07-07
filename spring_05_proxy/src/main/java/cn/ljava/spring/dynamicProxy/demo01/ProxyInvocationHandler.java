package cn.ljava.spring.dynamicProxy.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 用这个类自动生成代理类，代理的接口，传入的是接口的实现类
 * @Author: Liuys
 * @CreateDate: 2021/7/7 13:22
 * @Version: 1.0
 */
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Rent rent;
    public void setRent(Rent rent){
        this.rent = rent;
    }

    //生成得到代理类(固定的代码，rent是动态的)
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质，就是使用反射机制实现！
        seeHouse();
        Object result = method.invoke(rent, args);
        agencyFee();
        return result;
    }

    public void seeHouse(){
        System.out.println("中介带看房子！");
    }
    public void agencyFee(){
        System.out.println("中介收取中介费用！");
    }
}
