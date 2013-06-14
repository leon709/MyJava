package leon.ibatis.dao;

import java.util.List;

import leon.ibatis.dbo.Student;

import org.apache.ibatis.annotations.Select;

public interface StudentDao {
	@Select("select * from student")
	public List<Student> getStudentList();
	
	@Select("select * from student where id=#{id}")
	public Student getStudentById(Integer id);
}
