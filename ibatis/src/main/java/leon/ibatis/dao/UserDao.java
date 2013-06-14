package leon.ibatis.dao;

import java.util.List;

import leon.ibatis.dbo.User;

public interface UserDao {
	
	public User getUserById(int id) ;
	public int deleteUserById(int id);
	public List<User> getAllUser() ;
	public int addUser(User user) ;
	public int updateUser(User user);
}
