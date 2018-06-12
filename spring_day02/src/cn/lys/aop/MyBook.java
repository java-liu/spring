package cn.lys.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//增强/通知（也就是拦截到Joinpoint之后要做的事情）
public class MyBook {
	//前置通知
	public void before(){
		System.out.println("前置增强...................");
	}
	
	//后置通知
	public void after(){
		System.out.println("后置增强...................");
	}
	
	//异常通知
	public void advice1() throws Exception{
		
	}
	//环绕通知
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//方法之前
		System.out.println("方法之前..........");
		//执行被增强的方法
		proceedingJoinPoint.proceed();
		
		//方法之后
		System.out.println("方法之后...........");
	} 

}
