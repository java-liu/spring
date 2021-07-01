package cn.ljava.spring.Service.impl;

import javax.annotation.Resource;

import cn.ljava.spring.Dao.UserDao;
import cn.ljava.spring.Dao.OrderDao;
import cn.ljava.spring.Dao.impl.UserDaoImpl;
import cn.ljava.spring.Service.UserService;
import org.springframework.stereotype.Service;

//@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	//得到dao对象
	//定义dao类型属性
	//在dao属性上面使用注解，完成对象注入
	
	
	//@Autowired
	//private UserDao userDao;
	//name属性值是 注解创建dao对象的value值
	/*@Resource(name="userDao123")
	private UserDao userDao;
	
	@Resource(name="orderDao")
	private OrderDao orderDao;*/

	private UserDao userDao1;

	public void setUserDao1(UserDao userDao1) {
		this.userDao1 = userDao1;
	}

	private UserDao userDao2 = new UserDaoImpl();

	public void add(){
		System.out.println("service add...........");
		//userDao.add();
		//orderDao.add();
		userDao2.add();
		userDao1.add();
	}

}
