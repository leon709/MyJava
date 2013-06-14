package leon.ibatis.test;

import java.util.List;

import leon.ibatis.dao.UserDao;
import leon.ibatis.dao.impl.UserDaoImpl;
import leon.ibatis.dbo.User;

public class QueryTest {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();

		// 查询
		// System.out.println(userDao.getUserById(4));

		List<User> users = userDao.getAllUser();

		for (User u : users) {
			System.out.println(u);
		}
	}

}
