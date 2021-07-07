package cn.ljava.spring.staticProxy.demo1;

/**
 * @Description: 房东类
 * @Author: Liuys
 * @CreateDate: 2021/7/7 9:15
 * @Version: 1.0
 */
public class Landlord implements CommonSubject{
    @Override
    public void rent() {
        System.out.println("房东自己出租房子");
    }
}
