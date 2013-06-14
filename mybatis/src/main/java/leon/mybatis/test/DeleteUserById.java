package leon.mybatis.test;

import leon.mybatis.dao.UserDao;
import leon.mybatis.dao.UserDaoImpl;

public class DeleteUserById {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.deleteUserById(4));
	}

}
