package top.kinoko6.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import top.kinoko6.pojo.User;
import top.kinoko6.pojo.UserLoginRecord;

public interface UserMapper {
	
	@Insert("insert into T_user values(default, #{user_name},#{user_real_name},#{user_password},#{user_headphoto},"
			+ "#{user_id_card},#{user_email},#{user_level},#{user_exp},#{user_sign})")
	int insertUser(User user);

	@Select("select count(*) from T_user where user_name=#{0}")
	int selectUserNameExsist(String adminNo);

	@Select("select * from T_user where user_email=#{arg0} and user_password=#{arg1}")
	User userLoginMapper(String userEmail, String userPassword);

	@Select("select * from T_user where user_id=#{0}")
	User getUserSessionByIdMapper(String userId);

	int updateUserInfoMapper(User user);
	
	@Insert("insert into T_user_login_record values(default,#{user_id},#{login_time},#{user_ip},#{user_port}) ")
	int insertUserLoginRecord(UserLoginRecord loginRecord);
	
	@Select("select login_time from T_user_login_record where user_id=#{0}  ORDER BY login_time desc limit 1;")
	String selectUserLastLoginDayById(String user_id);

	@Update("update T_user set user_exp=user_exp+#{arg1} where user_id=#{arg0}")
	void updateUserExpByUserId(String userId, int i);
	
}
