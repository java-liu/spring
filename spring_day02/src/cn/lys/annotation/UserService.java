package cn.lys.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserService {
	
	//得到dao对象
	//定义dao类型属性
	//在dao属性上面使用注解，完成对象注入
	
	
	//@Autowired
	//private UserDao userDao;
	//name属性值是 注解创建dao对象的value值
	@Resource(name="userDao123")
	private UserDao userDao;
	
	@Resource(name="orderDao")
	private OrderDao orderDao;
	
	
	public void add(){
		System.out.println("service add...........");
		userDao.add();
		orderDao.add();
	}

}
