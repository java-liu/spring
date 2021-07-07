package cn.ljava.spring.staticProxy.demo1;

/**
 * @Description: 中介，去代理房东（landlord）
 * @Author: Liuys
 * @CreateDate: 2021/7/7 9:22
 * @Version: 1.0
 */
public class IntermediaryProxy implements CommonSubject {
    private Landlord landlord;
    public IntermediaryProxy(){}
    public IntermediaryProxy(Landlord landlord){
        this.landlord = landlord;
    }
    @Override
    public void rent() {
        seeHouse();
        landlord.rent();
        agencyFee();
    }
    /**
     * 中介自己的方法：收管理费用
     */
    public void agencyFee(){
        System.out.println("中介收取中介费用！");
    }

    public void seeHouse(){
        System.out.println("中介带你看房！");
    }
}
