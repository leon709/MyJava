package leon.mybatis.dao;

import java.util.List;

import leon.mybatis.vo.User;

public interface UserDao {
	
	public User getUserById(int id) ;
	public int deleteUserById(int id);
	public List<User> getAllUser() ;
	public int addUser(User user) ;
	public int updateUser(User user);
}
