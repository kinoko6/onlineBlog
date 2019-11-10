package top.kinoko6.pojo;

import java.util.Date;

public class UserLoginRecord {
	private String id;
	private String user_id;
	private String login_time;
	private String user_ip;
	private String user_port;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getUser_port() {
		return user_port;
	}
	public void setUser_port(String user_port) {
		this.user_port = user_port;
	}
	@Override
	public String toString() {
		return "UserLoginRecord [id=" + id + ", user_id=" + user_id + ", login_time=" + login_time + ", user_ip="
				+ user_ip + ", user_port=" + user_port + "]";
	}
	
	
	
}
