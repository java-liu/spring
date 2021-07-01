package cn.ljava.spring.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="user")  //就相当于 <bean id="user" class=""></bean>
@Scope(value="singleton")//prototype 多实例
public class User {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void add(){
		
		System.out.println("add............");
	}
	

}
