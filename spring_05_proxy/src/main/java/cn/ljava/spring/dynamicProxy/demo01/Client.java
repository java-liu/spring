package cn.ljava.spring.dynamicProxy.demo01;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/7 13:42
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);
        Rent proxy = (Rent) pih.getProxy();//这里的proxy就是动态生成的
        proxy.rent();
    }
}
