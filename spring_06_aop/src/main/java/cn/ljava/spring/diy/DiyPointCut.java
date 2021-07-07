package cn.ljava.spring.diy;

public class DiyPointCut {
    public void before(){
        System.out.println("before()方法之前执行");
    }
    public void after(){
        System.out.println("after()方法之后执行");
    }
}
