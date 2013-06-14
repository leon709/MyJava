package leon.ibatis.dao.impl;

import java.util.List;

import leon.ibatis.dao.StudentDao;
import leon.ibatis.dbo.Student;
import leon.ibatis.util.IbatisDaoUtil;

import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentList() {
		SqlSession session = IbatisDaoUtil.getSqlSession();
		List<Student> list = session.selectList("student.getStudentList");
		session.close();
		return list;
	}

	@Override
	public Student getStudentById(Integer id) {
		SqlSession session = IbatisDaoUtil.getSqlSession();
		
		Student stu = (Student) session.selectOne("student.getStudentById",id);
		session.close();
		return stu;
	}

}
