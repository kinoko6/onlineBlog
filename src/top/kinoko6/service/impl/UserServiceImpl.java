package top.kinoko6.service.impl;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.Comment;
import top.kinoko6.pojo.User;
import top.kinoko6.pojo.UserLoginRecord;
import top.kinoko6.service.UserService;
import top.kinoko6.utils.StringUtils;
import top.kinoko6.constants.UserConstants;
import top.kinoko6.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public int insertUserService(User user) throws Exception {
		//新用户初始化登记和经验值
		user.setUser_level(1);
		user.setUser_exp(1);
		//密码加密
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(user.getUser_password().getBytes());
		String pwd = new String(md.digest(),"utf-8");
		user.setUser_password(pwd);
		int result = userMapper.insertUser(user);
		return result;
	}

	//判断用户名是否存在
	@Override
	public int selectUserNameExsist(String adminNo) {
		return userMapper.selectUserNameExsist(adminNo);
	}

	@Override
	public User userLoginService(String userEmail, String userPassword) throws Exception {
		if(StringUtils.isEmpty(userEmail) || StringUtils.isEmpty(userPassword))
		{
			return null;
		}
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(userPassword.getBytes());
		userPassword=new String(md.digest(),"utf-8");
		return userMapper.userLoginMapper(userEmail,userPassword);
	}

	@Override
	public User getUserSessionByIdService(String userId) {
		User user=userMapper.getUserSessionByIdMapper(userId);
		if(user!=null && StringUtils.isEmpty(user.getUser_headphoto()))
		{
			user.setUser_headphoto(UserConstants.DEFALUT_USER_HEAD_PHOTO);
		}
		return user;
	}

	@Override
	public void clearUserMessage(HttpServletRequest req, HttpServletResponse resp) {
		//清除cookie信息
		Cookie[] cookies = req.getCookies();
		Cookie c=new Cookie("user_id", null);
		c.setMaxAge(0);
		c.setPath("/");
		resp.addCookie(c);
		//清除session信息
		req.getSession().removeAttribute("user");
	}

	@Override
	public User updateUserService(User user) {
		String userid=user.getUser_id();
		userMapper.updateUserInfoMapper(user);
		user=userMapper.getUserSessionByIdMapper(userid);
		return user;
	}

	@Override
	public void processUserImg(User user, MultipartFile userPhotoFile, HttpServletRequest req) throws IOException {
		if(userPhotoFile!=null && !StringUtils.isEmpty(userPhotoFile.getOriginalFilename()) )
		{
			String fileName=UUID.randomUUID().toString()+userPhotoFile.getOriginalFilename().substring(userPhotoFile.getOriginalFilename().lastIndexOf("."));
			FileUtils.copyInputStreamToFile(userPhotoFile.getInputStream(), new File(req.getServletContext().getRealPath("upload"),fileName));
			user.setUser_headphoto("upload/"+fileName);
		}
	}

	@Override
	public void loginSuccessProcess(User user, HttpServletRequest req,HttpServletResponse resp) {
		//三天免登录
		Cookie c=new Cookie("user_id", user.getUser_id());
		c.setMaxAge(3600*24*3);
		c.setPath("/");
		resp.addCookie(c);
	}

	@Override
	public void insertUserLoginRecord(UserLoginRecord loginRecord) {
		userMapper.insertUserLoginRecord(loginRecord);
	}

	@Override
	public String selectUserLastLoginDayById(String user_id) {
		return userMapper.selectUserLastLoginDayById(user_id);
	}

	@Override
	public void updateUserExpByUserId(String userId, int i) {
		userMapper.updateUserExpByUserId(userId,i);
	}

	@Override
	public List<Comment> loadCommentsUsers(List<Comment> comments) {
		for (Comment comment : comments) {
			comment.setUser(getUserSessionByIdService(comment.getUser_id()));
			comment.setReply_user_info(getUserSessionByIdService(comment.getReply_user_id()));
		}
		return comments;
	}

	@Override
	public List<Article> loadArticleListUserInfos(List<Article> articles) {
		for (Article article : articles) {
			article.setAuthor(getUserSessionByIdService(article.getUser_id()));
		}
		return articles;
	}


	
}
