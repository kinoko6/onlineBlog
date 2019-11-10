package top.kinoko6.constants;

/**
 * 邮箱验证的常量接口
 * 
 * @author 童松铅
 * @ClassName: EmailConstants
 * @Description: TODO
 * @date 2019年10月25日
 *
 */
public interface EmailConstants {
	
	/**
	 *  常用配置
	 */
	//发件人的邮箱    一般是企业邮箱由于没有企业邮箱  因此使用了个人邮箱
	String SEND_EMAIL_ACCOUNT="877399825@qq.com";
	//发件人邮箱的密码
	String SEND_EMAIL_PASSWORD="vrlyzzmtuuwbbfda";
	//发件人邮箱的SMTP服务器地址
	String SEND_SMTP_HOST_ADDR="smtp.qq.com";
	
	
	/**
	 * 核心配置
	 */
	//邮件传输协议
	String MAIL_TRANSGER_PROTOCAL="smtp";
	//是否需要身份验证
	String MAIL_SMTP_AUTH="true";
	
}
