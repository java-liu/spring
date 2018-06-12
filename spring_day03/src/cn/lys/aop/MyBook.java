package cn.lys.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	
	//在方法上面使用注解增强操作
	@Before(value="execution(* cn.lys.aop.Book.*(..))")
	public void before(){
		System.out.println("before前置...........");
	}

}
