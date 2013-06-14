package leon.mybatis.test;

import leon.mybatis.dao.UserDao;
import leon.mybatis.dao.UserDaoImpl;
import leon.mybatis.vo.User;

public class AddUser {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUsername("Teddy");
		user.setPassword("abc");
		user.setGroupname("pm");
		
		// 添加
		System.out.println(userDao.addUser(user));
	}

}
