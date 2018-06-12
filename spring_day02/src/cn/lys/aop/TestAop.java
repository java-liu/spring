package cn.lys.aop;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	Logger logger = Logger.getLogger(TestAop.class.getName());
	@Test
	public void testAop(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		Book book = (Book) context.getBean("book");
		ServletConfig config = new ServletConfig() {
			
			@Override
			public String getServletName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Enumeration<String> getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getInitParameter(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		book.add();
		logger.info("aaa");
	}

}
