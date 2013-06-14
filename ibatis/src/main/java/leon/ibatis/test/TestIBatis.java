package leon.ibatis.test;

import java.util.List;

import leon.ibatis.dao.StudentDao;
import leon.ibatis.dbo.Student;
import leon.ibatis.util.IbatisDaoUtil;

import org.apache.ibatis.session.SqlSession;

public class TestIBatis {

	public static void main(String[] args) throws Exception {
		SqlSession session = IbatisDaoUtil.getSqlSession();
		StudentDao studentDao = session.getMapper(StudentDao.class);

		List<Student> list = studentDao.getStudentList();
		int size = list.size();
		System.out.println(size);
		
		for(Student s:list){
			System.out.println(s.getId()+" "+s.getName()+" "+s.getAge());
		}
		
		Student student = studentDao.getStudentById(2);
		System.out.println(student.getName()+" "+student.getAge());
	}

}
