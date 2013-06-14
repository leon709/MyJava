package leon.ibatis.dbo;

public class User {
	private int userid;
	private String username;
	private String password;
	private String groupname;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int id) {
		this.userid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Override
	public String toString() {
		return "[" + userid + "," + username+"," + password+"," + groupname+"]";
	}
}
