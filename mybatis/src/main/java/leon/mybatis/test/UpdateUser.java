package leon.mybatis.test;

import leon.mybatis.dao.UserDao;
import leon.mybatis.dao.UserDaoImpl;
import leon.mybatis.vo.User;

public class UpdateUser {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUserid(3);
		user.setUsername("Sam");
		
		System.out.println(userDao.updateUser(user));
	}

}
