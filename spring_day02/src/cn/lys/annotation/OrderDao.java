package cn.lys.annotation;

import org.springframework.stereotype.Component;

@Component("orderDao")
public class OrderDao {
	public void add(){
		System.out.println("order Dao ..............");
	}

}
