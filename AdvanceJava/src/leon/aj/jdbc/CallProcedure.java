package leon.aj.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallProcedure {
	public static final String USERNAME="root";
	public static final String PASSWORD="leonsu";
	public static final String URL="jdbc:mysql://localhost:3306/d_db1";
	public static void main(String[] args) {
		Connection conn=null;
		CallableStatement cs = null;
		//ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "{call adduser(?,?,?)}";
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.setString(1, "leon709");
			cs.setString(2,"leonsu709");
			cs.executeUpdate();
			
			int id = cs.getInt("id");
			System.out.println(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn !=null ){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
