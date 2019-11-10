package top.kinoko6.utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import top.kinoko6.constants.EmailConstants;

public class EmailHelper {
	//发件人的邮箱地址和密码
	public static String sendEmailAccount=EmailConstants.SEND_EMAIL_ACCOUNT;
	public static String sendEmailPassword=EmailConstants.SEND_EMAIL_PASSWORD;
	//发件人邮箱的SMTP服务器地址
	public static String sendEmailSMTPHost=EmailConstants.SEND_SMTP_HOST_ADDR;
	//收件人地址
	public static String receiveMailAccount="";
	public static void sendEmail(String RandomCode,String receiveEmail) throws MessagingException {
		//参数配置
		Properties props =new Properties();
		props.setProperty("mail.transport.protocol", EmailConstants.MAIL_TRANSGER_PROTOCAL);
		props.setProperty("mail.smtp.host", sendEmailSMTPHost);
		props.setProperty("mail.smtp.auth", EmailConstants.MAIL_SMTP_AUTH);
		props.setProperty("mail.transport.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		receiveMailAccount=receiveEmail;
		//根据配置的创建会话对象，用于邮件和服务器交互
			Session session=Session.getDefaultInstance(props);
			//设置为debug模式，可以查看详细的发送log
			//session.setDebug(true);
			//创建一封邮件
			Message message =createMimeMessage(session, sendEmailAccount, receiveMailAccount,RandomCode);
			//根据session获取邮件传输对象
			Transport transport=session.getTransport();
			//使用邮箱账户和密码链接邮件服务器,这里认证的邮箱必须与message中的发件人一致，否则会报错;
			transport.connect(sendEmailAccount, sendEmailPassword);
			//发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			//关闭链接
			transport.close();
	}

	//创建一封简单邮件
	private static Message createMimeMessage(Session session,String sendMail,String receiveMail,String RandomCode) throws MessagingException
	{
		Message message =new MimeMessage(session);
		message.setFrom(new InternetAddress(sendMail));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));
		//设置邮件标题
		message.setSubject("全映苏应校园说");
		//设置邮件正文
		message.setContent("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<title>邮箱验证</title>\r\n" + 
				"		<style type=\"text/css\">\r\n" + 
				"			.banner{\r\n" + 
				"				background: #999;\r\n" + 
				"				padding: 10px 0;\r\n" + 
				"			}\r\n" + 
				"			.msbox{\r\n" + 
				"				width: 300px;\r\n" + 
				"				height: 150px;\r\n" + 
				"				margin: 40px auto;\r\n" + 
				"				background: lightskyblue;\r\n" + 
				"				text-align: center;\r\n" + 
				"				padding-top:40px;\r\n" + 
				"				color: white;\r\n" + 
				"			}\r\n" + 
				"           body{\r\n"+
				"           background:url(images/background.jpg) no-repeat center center;\r\n"+
				"			background-size:cover;\r\n"+
				"			}\r\n"+			
				"		</style>\r\n" + 
				"	</head>\r\n" + 
				"	<body>	\r\n" + 
				"		\r\n" + 
				"			<div class=\"banner\"><h1>请在邮箱注册页面输入如下验证码完成信息的验证：</h3></div>\r\n" + 
				"			<hr/>\r\n" + 
				"			<div class=\"msbox\">您的验证码是:"+RandomCode+"</div>\r\n" + 
				"	</body>\r\n" + 
				"</html>\r\n" + 
				"", "text/html;charset=utf-8");
		message.setSentDate(new Date());
		//保存设置
		message.saveChanges();
		return message;
	}
}
