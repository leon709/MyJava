package leon.mybatis.dao;

import java.util.List;

import leon.mybatis.util.DBUtil;
import leon.mybatis.vo.User;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
public class UserDaoImpl implements UserDao{
	private static SqlSessionFactory sqlSessionFactory = DBUtil.getSqlSessionFactory();

	public User getUserById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = (User) session.selectOne("user.selectUser", id);	//user.selectUser与sqlmap中namespace一致
			return user;
		} finally {
			session.close();
		}
	}
	public int deleteUserById(int id){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int i = session.delete("user.deleteUserById", id);
			if(i >= 1) 
				session.commit();
			return i;
		} finally {
			session.close();
		}
	}
	public List<User> getAllUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<User> users = session.selectList("user.selectAllUser");
			return users;
		} finally {
			session.close();
		}
	}
	public int addUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int i = session.insert("user.insertUser", user);
			if(i >= 1) session.commit();
			return i;
		} finally {
			session.close();
		}
	}
	@Override
	public int updateUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int i = session.delete("user.updateUser", user);
			if(i >= 1) 
				session.commit();
			return i;
		} finally {
			session.close();
		}
	}
	
}