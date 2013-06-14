package leon.ibatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class IbatisDaoUtil {
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;
	static{
		try{
			String resource = "ibatis-configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession(){
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	public static void closeSqlSession(){
		if(sqlSession !=null){
			sqlSession.close();
		}
	}
}
