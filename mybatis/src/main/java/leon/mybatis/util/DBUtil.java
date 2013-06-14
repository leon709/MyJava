package leon.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static String resource = "mybatis/mybatis-cfg.xml";
	private static Reader reader;
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			System.out.println("IO异常");
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		return sqlSessionFactory;
	}
}