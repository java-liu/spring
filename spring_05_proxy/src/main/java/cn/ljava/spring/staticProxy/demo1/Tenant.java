package cn.ljava.spring.staticProxy.demo1;

/**
 * @Description: 租客
 * @Author: Liuys
 * @CreateDate: 2021/7/7 9:19
 * @Version: 1.0
 */
public class Tenant {
    public static void main(String[] args) {
        //房东要出租房子了
        Landlord landlord = new Landlord();
        //代理，中介帮房东租房子，但是代理角色一般会有一些附属操作！
        IntermediaryProxy proxy = new IntermediaryProxy(landlord);
        //不用面对房东，直接找中介租房即可
        proxy.rent();
    }
}
