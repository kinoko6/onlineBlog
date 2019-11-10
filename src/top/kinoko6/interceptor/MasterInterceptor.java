package top.kinoko6.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import top.kinoko6.constants.UserConstants;
import top.kinoko6.pojo.User;
import top.kinoko6.service.UserService;
import top.kinoko6.service.impl.UserServiceImpl;
import top.kinoko6.utils.StringUtils;


public class MasterInterceptor implements HandlerInterceptor {

	@Resource
	private UserService userServiceImpl;
	
	Logger logger=Logger.getLogger(MasterInterceptor.class);
	//在控制器之前执行
		//请求拦截 session 失效处理
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object controllerMethod) throws Exception {
		//判断session是否存在  有就放行
		if(req.getSession().getAttribute("user")==null)
		{
			Cookie[] c=req.getCookies();
			//如果cookie不为空
			if(c!=null) {
				String userId=null;
				for (Cookie cookie : c) {
					if("user_id".equals(cookie.getName()))
					{
						userId = cookie.getValue();
					}
				}
				//如果cookie中学生id不为空
				if(userId!=null)
				{
					System.out.println(userId);
					User user=userServiceImpl.getUserSessionByIdService(userId);
					//如果查询到改学生 则刷新session并放行请求
					if(user!=null)
					{
						req.getSession().setAttribute("user", user);
						return true;
					}
				}
			}
			//其他情况一律需要重新登录并且拦截请求
			resp.sendRedirect("login.jsp");
			return false;
		}
		return true;
	}
	
	//在控制器之后 jsp之前执行
		//日志记录
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object controllerMethod, ModelAndView mav)
			throws Exception {
		//用户数据模糊处理  与  用户空值处理
		if(req.getSession().getAttribute("user")!=null)
		{
				User user =(User) req.getSession().getAttribute("user");
				user.setUser_email(StringUtils.dimEmail(user.getUser_email()));
				user.setUser_id_card(StringUtils.dimUserIdCard(user.getUser_id_card()));
				if(StringUtils.isEmpty(user.getUser_sign()))
				{
					user.setUser_sign(UserConstants.DEFAULT_USER_SIGN);
				}
				if(StringUtils.isEmpty(user.getUser_headphoto()))
				{
					user.setUser_headphoto(UserConstants.DEFALUT_USER_HEAD_PHOTO);
				}
		}
	}
	
	//jsp之后执行
		//异常收集
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception e)
			throws Exception {
		if(e!=null)
		{
			logger.error(e.getMessage());
		}
	}
}
