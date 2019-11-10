package top.kinoko6.utils;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import top.kinoko6.constants.ArticleConstants;
import top.kinoko6.constants.UserConstants;

/**
 * 字符串工具类
 * 
 * @author 童松铅
 * @ClassName: StringUtils
 * @Description: TODO
 * @date 2019年11月1日
 *
 */
public class StringUtils {
	
	public static final Random random=new Random();
	//生成邮箱验证码
	public static String generateRancode(int len)
	{
		String result="";
		for (int i = 0; i < len; i++) {
			result+=random.nextInt(10);
		}
		return result;
	}	
	
	//邮箱模糊
	public static String dimEmail(String email) {
		int endIndex = email.indexOf("@");
		String suffix=email.substring(endIndex);
		String prefix=email.substring(0,UserConstants.USER_EMAIL_DIM_LENGTH);
		return prefix+"******"+suffix;
	}
	//身份证模糊
	public static String dimUserIdCard(String idNumber)
	{
		return idNumber.substring(0,UserConstants.USER_ID_CARD_DIM_LENGTH)+"******"+idNumber.substring(idNumber.length()-UserConstants.USER_ID_CARD_DIM_LENGTH);
	}
	//判断空串和Null值
	public static boolean isEmpty(String str)
	{
		if(str==null || "".equals(str))
		{
			return true;
		}
		return false;
	}
	//生成UUID
	public static String getUUID()
	{
		return UUID.randomUUID().toString();
	}
	
	//除去字符串中的空白字符 包括换行制表。。。
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	//提取Content文字
	public static String StripHT(String strHtml,int count) {
		 String txtcontent = strHtml.replaceAll("</?[^>]+>", ""); //剔出<html>的标签  
        txtcontent = txtcontent.replaceAll("<a>\\s*|\t|\r|\n</a>", "");//去除字符串中的空格,回车,换行符,制表符  
        txtcontent=replaceBlank(txtcontent);
        if(txtcontent.length()>count)
        {
        	txtcontent=txtcontent.substring(0,count-3);
        	txtcontent+="…";
        }
        return txtcontent;
   }
	
}
