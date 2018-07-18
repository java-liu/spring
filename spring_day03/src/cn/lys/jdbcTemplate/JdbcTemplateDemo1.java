package cn.lys.jdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.core.appender.db.jdbc.DriverManagerConnectionSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcTemplateDemo1 {
	
	//查询操作
	/*
	 *QueryRunner runner = new QueryRunner(dataSource);
	 *返回对象
	 *runner.query(sql,new BeanHandler<User.class>); 
	 * 
	 * 返回list集合
	 * runner.query(sql,new BeanListHander<User>(User.class))
	 * 
	 * 1、在dbutils时候，有接口ResultSetHandler
	 * dbutils提供了针对不同的结果的实现类
	 * 
	 * 2、jdbcTemplate实现查询，有接口RowMapper
	 * jdbcTemplate针对这个接口没有提供实现类，得到不同的类型数据需要自己进行数据封装
	 * */
	
	@Test
	public void testCount(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");//数据库路径 + 对应的数据库
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		
		//设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//定义sql
		String sql = "select * from user where id = ?";
		//调用jdbcTemplate的方法实现
		//第二个参数是接口RowMapper,需要自己写类实现接口，自己做数据封装
		User user = jdbcTemplate.queryForObject(sql, new myRowMapper(),"3");
		System.out.println(user);
	}
	
	//JDBC 实现代码 
	@Test
	public void testJdbc(){
		Connection conn = null;
		PreparedStatement psmt = null;//预编译
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			conn = DriverManager.getConnection("jdbc:mysql:///test","root","password");
			//编写sql语句
			String sql = "select * from user where id = ?";
			//预编译sql
			psmt = conn.prepareStatement(sql);
			//设置参数值
			psmt.setString(1, "2");
			//执行sql
			rs = psmt.executeQuery();
			//遍历结果集
			while(rs.next()){
				//得到结果集
				String name = rs.getString("name");
				String id = rs.getString("id");
				//放到user对象里面
				User user = new User();
				user.setId(id);
				user.setName(name);
				
				
				System.out.println(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//1 添加操作
	@Test
	public void add(){
		
		//C3P0连接数据库信息
		/*ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///test");
		dataSource.setUser("root");
		dataSource.setPassword("password");*/
		
		
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");//数据库路径
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		//创建jdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		//创建sql语句
		//调用jdbcTemplate对象里面的方法实现操作
		
		//String sql = "insert into user value(?,?)";
		
		//int row = jdbcTemplate.update(sql,"1","lys");
		//System.out.println(row);
		
		//2修改操作
		String sql1 = "update user set name = ? where id =?";
		int row1 = jdbcTemplate.update(sql1,"yongshan","1");
		System.out.println(row1);
		
	
	}
	
	//3-删除操作
	@Test
	public void delete(){
		//设置数据库信息
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		
		//创建JdbcTemplate对象，设置数据源
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql  = "delete from user where id = ?";
		int row = jdbcTemplate.update(sql,"1");
		System.out.println(row);
	}

}

class myRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		//1 从结果集里面把数据 得到
		String name = rs.getString("name");
		String id = rs.getString("id");
		//2把得到的数据 封装到对象里面
		User user = new User();
		user.setId(id);
		user.setName(name);
		return user;
	}
	
}
