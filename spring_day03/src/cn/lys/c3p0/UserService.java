package cn.lys.c3p0;

public class UserService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add(){
		userDao.add();
	}

}
