package top.kinoko6.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import top.kinoko6.constants.UserConstants;


@WebListener
public class ApplicationListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute(UserConstants.SESSION_ONLINE_USER_NUMBER, 0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	System.out.println("我被销毁了");
	}
}
