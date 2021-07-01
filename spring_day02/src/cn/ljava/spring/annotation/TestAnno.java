package cn.ljava.spring.annotation;

import cn.ljava.spring.Service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {
	
	@Test
	public void testUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
		user.add();
	}
	
	@Test
	public void testUserService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
		System.out.println(userService);
		userService.add();
	}

}
