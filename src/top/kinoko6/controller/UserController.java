package top.kinoko6.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.kinoko6.pojo.User;
import top.kinoko6.service.UserService;
import top.kinoko6.utils.EmailHelper;
import top.kinoko6.utils.StringUtils;


/**
 * 
 * 负责用户相关的操作 
 * @author 童松铅
 * @ClassName: UserController
 * @Description: TODO
 * @date 2019年10月29日
 *
 */
@Controller
public class UserController {
	
	private Logger logger =Logger.getLogger(UserController.class);
	@Resource
	private UserService userServiceImpl;
	
	//用户注册
	@RequestMapping("register")
	public void userRegister(User user,HttpServletResponse resp) throws Exception {
				int res = userServiceImpl.insertUserService(user);
				resp.getWriter().write(user.toString());
	}
	
	//用户邮箱验证
	@RequestMapping("mailverify")
	public void mailVerify(String receiveEmail,HttpServletResponse resp) throws Exception {
			String ranCode=StringUtils.generateRancode(6);
			System.out.println(receiveEmail);
			try {
				EmailHelper.sendEmail(ranCode, receiveEmail);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			resp.getWriter().write(ranCode);
	}
	
	//判断用户名是否唯一
	@RequestMapping("selectUniqueAdminNo")
	@ResponseBody
	public int selectUniqueAdminNo(String adminNo) {
		return userServiceImpl.selectUserNameExsist(adminNo);
	}
	
	//用户登录
	@RequestMapping("login")
	public String userLogin(String userEmail,String userPassword,HttpSession session,HttpServletResponse resp,HttpServletRequest req) throws Exception {
		User user=null;
		user=userServiceImpl.userLoginService(userEmail,userPassword);
		if(user!=null)
		{
			//用户登录成功后的处理 
			userServiceImpl.loginSuccessProcess(user,req,resp);
			//添加session
			session.setAttribute("user", user);
			session.removeAttribute("login_message");
			return "redirect:toMain";
		}else {
			session.setAttribute("login_message", "邮箱或密码错误请重新输入");
			return "redirect:login.jsp";
		}
	}
	
	//用户信息修改
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(User user,MultipartFile userPhotoFile,HttpServletRequest req,HttpSession session) throws IOException
	{
		user.setUser_id( ( (User) session.getAttribute("user")).getUser_id());
		//处理用户上传的头像 
		userServiceImpl.processUserImg(user,userPhotoFile,req);
		user = userServiceImpl.updateUserService(user);
		session.setAttribute("user", user);
		return "redirect:userPage";
	}
	
	//用户退出
	@RequestMapping("quit")
	public String quit(HttpServletRequest req,HttpServletResponse resp) {
		//清除cookie信息和session信息
		userServiceImpl.clearUserMessage(req,resp);
		return "forward:login.jsp";
	}
}
