package top.kinoko6.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import top.kinoko6.pojo.Article;

public class DateUtils {
	
	public  static final SimpleDateFormat DATE_TIME_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public  static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");
	
	//判断传入的字符串是否是当天    是返回true 不是返回false
	public static boolean isToday(String dateStr)
	{	
		String inputDate = dateStr.split(" ")[0];
		return inputDate.equals(DATE_FORMAT.format(new Date()));
	}
	
	
	//获取当前时间      格式：yyyy-MM-dd HH:mm:ss
	public static String getCurrentTime() {
		return DATE_TIME_FORMAT.format(new Date());
	}
	//获取今天的日期   格式：yyyy-MM-dd
	public static String getTodayDate() {
		return DATE_FORMAT.format(new Date());
	}

	/**
	 * 将获得的文章日期去重后返回
	 * @param articleList
	 * @return 
	 */
	public static List<String> distinctDateForArticles(List<Article> articleList) {
		Set<String>  dateSet=new HashSet<>();
		List<String> result=new ArrayList<String>();
		for (Article article : articleList) {
			String[] dateArr = article.getPublish_date().split(" ");
			String[] split = dateArr[0].split("-");		//年月日数组
			dateSet.add(split[0]+"-"+split[1]);		//获取月份
		}
		for (String str : dateSet) {
			result.add(str);
		}
		//倒序处理
		result.sort((str1,str2)->{
			return -str1.compareTo(str2);
		});
		return result;
	}
}
