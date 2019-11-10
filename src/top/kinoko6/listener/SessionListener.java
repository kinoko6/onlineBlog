package top.kinoko6.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import top.kinoko6.constants.UserConstants;
import top.kinoko6.pojo.User;
import top.kinoko6.pojo.UserLoginRecord;
import top.kinoko6.service.UserService;
import top.kinoko6.utils.DateUtils;

@WebListener
public class SessionListener implements HttpSessionAttributeListener,HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		application.setAttribute(UserConstants.SESSION_ONLINE_USER_NUMBER, (int)application.getAttribute(UserConstants.SESSION_ONLINE_USER_NUMBER)+1);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		application.setAttribute(UserConstants.SESSION_ONLINE_USER_NUMBER, (int)application.getAttribute(UserConstants.SESSION_ONLINE_USER_NUMBER)-1);
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		if(se.getName().equals("user")) {
		//添加登录信息
			//获取用户登录信息
			String loginIP = req.getRemoteAddr();
			String userId=((User)se.getValue()).getUser_id();
			int loginPort = req.getRemotePort();
			UserLoginRecord loginRecord=new UserLoginRecord();
			loginRecord.setLogin_time(DateUtils.getCurrentTime());
			loginRecord.setUser_ip(loginIP);
			loginRecord.setUser_port(loginPort+"");
			loginRecord.setUser_id(userId);
			UserService userServiceImpl = WebApplicationContextUtils.getWebApplicationContext((se.getSession().getServletContext())).getBean(UserService.class);
			//检查用户上次登录的日期
			String loginTime=userServiceImpl.selectUserLastLoginDayById(userId);
			//如果用户上次登录不是今天 就让用户经验+1
			if(!DateUtils.isToday(loginTime)) {
				userServiceImpl.updateUserExpByUserId(userId,1);
			}
			userServiceImpl.insertUserLoginRecord(loginRecord);
		}
	}
	
}
