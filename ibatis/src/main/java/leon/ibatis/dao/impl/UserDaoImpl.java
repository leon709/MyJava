package leon.ibatis.dao.impl;

import java.util.List;

import leon.ibatis.dao.UserDao;
import leon.ibatis.dbo.User;
import leon.ibatis.util.IbatisDaoUtil;

import org.apache.ibatis.session.SqlSession;
public class UserDaoImpl implements UserDao{

	public User getUserById(int id) {
		SqlSession session = IbatisDaoUtil.getSqlSession();
		try {
			User user = (User) session.selectOne("user.selectUser", id);	//user.selectUser与sqlmap中namespace一致
			return user;
		} finally {
			session.close();
		}
	}
	public int deleteUserById(int id){
		SqlSession session = IbatisDaoUtil.getSqlSession();
		try {
			int i = session.delete("user.deleteUserById", id);
			if(i >= 1) 
				session.commit();
			return i;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		SqlSession session = IbatisDaoUtil.getSqlSession();
		try {
			List<User> users = session.selectList("user.selectAllUser");
			return users;
		} finally {
			session.close();
		}
	}
	public int addUser(User user) {
		SqlSession session = IbatisDaoUtil.getSqlSession();
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
		SqlSession session = IbatisDaoUtil.getSqlSession();
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