package leon.aj.jdbc;

import java.sql.Connection;
import java.util.List;

/**
 * JDBC Connection pool
 * @author 123
 * 
 */
public class JDBCManager {

	List<Connection> conns;
	int minSize;
	int maxSize;
	
	void initPool(){
		minSize=5;
		maxSize=20;
	}
	
	public Connection getConn(){
		return null;
	}
}
