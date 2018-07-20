package cn.lys.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	//得到JdbcTemplate对象
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void add(){
		//创建jdbctemplate对象
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into user value (?,?)";
		jdbcTemplate.update(sql,"4","jack");
		
		
		
		
		System.out.println("add成功！！！！！！！！！！！！!");
	}

}
