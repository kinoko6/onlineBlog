package top.kinoko6.pojo;

import java.io.Serializable;

import top.kinoko6.constants.UserConstants;

public class User implements Serializable{
	private String user_id;
	private String user_name;
	private String user_real_name;
	private String user_password;
	private String user_headphoto;
	private String user_id_card;
	private String user_email;
	private int user_level;
	private int user_exp;
	private String user_sign;
	public User() {
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_real_name() {
		return user_real_name;
	}
	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_headphoto() {
		return user_headphoto;
	}
	public void setUser_headphoto(String user_headphoto) {
		this.user_headphoto = user_headphoto;
	}
	public String getUser_id_card() {
		return user_id_card;
	}
	public void setUser_id_card(String user_id_card) {
		this.user_id_card = user_id_card;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getUser_level() {
		return user_level;
	}
	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
	public int getUser_exp() {
		return user_exp;
	}
	public void setUser_exp(int user_exp) {
		this.user_exp = user_exp;
	}
	public String getUser_sign() {
		return user_sign;
	}
	public void setUser_sign(String user_sign) {
		this.user_sign = user_sign;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_real_name=" + user_real_name
				+ ", user_password=" + user_password + ", user_headphoto=" + user_headphoto + ", user_id_card="
				+ user_id_card + ", user_email=" + user_email + ", user_level=" + user_level + ", user_exp=" + user_exp
				+ ", user_sign=" + user_sign + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + user_exp;
		result = prime * result + ((user_headphoto == null) ? 0 : user_headphoto.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_id_card == null) ? 0 : user_id_card.hashCode());
		result = prime * result + user_level;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + ((user_real_name == null) ? 0 : user_real_name.hashCode());
		result = prime * result + ((user_sign == null) ? 0 : user_sign.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_exp != other.user_exp)
			return false;
		if (user_headphoto == null) {
			if (other.user_headphoto != null)
				return false;
		} else if (!user_headphoto.equals(other.user_headphoto))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_id_card == null) {
			if (other.user_id_card != null)
				return false;
		} else if (!user_id_card.equals(other.user_id_card))
			return false;
		if (user_level != other.user_level)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_real_name == null) {
			if (other.user_real_name != null)
				return false;
		} else if (!user_real_name.equals(other.user_real_name))
			return false;
		if (user_sign == null) {
			if (other.user_sign != null)
				return false;
		} else if (!user_sign.equals(other.user_sign))
			return false;
		return true;
	}

	
	
	
}
