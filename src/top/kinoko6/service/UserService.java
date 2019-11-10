package top.kinoko6.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.Comment;
import top.kinoko6.pojo.User;
import top.kinoko6.pojo.UserLoginRecord;

public interface UserService {
	
	int insertUserService(User user) throws Exception;

	int selectUserNameExsist(String adminNo);

	User userLoginService(String userEmail, String userPassword) throws Exception;

	User getUserSessionByIdService(String userId);


	void clearUserMessage(HttpServletRequest req, HttpServletResponse resp);


	User updateUserService(User user);

	void processUserImg(User user, MultipartFile userPhotoFile, HttpServletRequest req) throws IOException;

	void loginSuccessProcess(User user,HttpServletRequest req, HttpServletResponse resp);

	void insertUserLoginRecord(UserLoginRecord loginRecord);


	String selectUserLastLoginDayById(String user_id);


	void updateUserExpByUserId(String userId, int i);

	List<Comment> loadCommentsUsers(List<Comment> comments);

	List<Article> loadArticleListUserInfos(List<Article> articles);

}
