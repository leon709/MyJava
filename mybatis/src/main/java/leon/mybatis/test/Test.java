package leon.mybatis.test;

import java.util.List;

import leon.mybatis.dao.UserDao;
import leon.mybatis.dao.UserDaoImpl;
import leon.mybatis.vo.User;

public class Test {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		
		// 查询
		//System.out.println(userDao.getUserById(4));
		
		List<User> users = userDao.getAllUser();
		
		for (User u : users) {
			System.out.println(u);
		}
	}

}
