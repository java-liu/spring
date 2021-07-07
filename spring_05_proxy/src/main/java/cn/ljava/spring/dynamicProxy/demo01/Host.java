package cn.ljava.spring.dynamicProxy.demo01;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/7 13:43
 * @Version: 1.0
 */
public class Host implements Rent{
    public void rent(){
        System.out.println("房东要出租房子了！");
    }
}
