package top.kinoko6.utils;

import java.util.ArrayList;
import java.util.List;

import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.Comment;


/**
 * 用于对实体类进行装配
 * 
 * @author 童松铅
 * @ClassName: PojoUtils
 * @Description: TODO
 * @date 2019年11月5日
 *
 */
public class PojoUtils {

	
	/**
	 * 根据直接评论和间接评论对评论信息整理组织  
	 * 将间接评论作为直接评论subComment列表的值
	 * 
	 * ( user_id comment_content reply_user_id   )
	 * 		1	  	'xxxx'				0
	 * 		2		'yyyy'				1
	 * 		2		'zzzz'				1
	 * 		3		'zzzx'				1
	 * 			.....
	 * 
	 * @param comments
	 * @return 
	 * @return
	 */
	public static List<Comment> organizeCommnets(List<Comment> comments)
	{
		System.out.println(comments.size());
		for (Comment comment : comments) {
			List<Comment> subComments=new ArrayList<>(); 
			//如果不是直接评论不做处理 
			if(!comment.getSuper_id().equals("0")) continue;
			//遍历整个评论 如果不是当前评论并且回复的id=当前Userid就添加到subComments列表中
			for (Comment innerComment : comments) {
				if(!innerComment.equals(comment) && innerComment.getSuper_id().equals(comment.getId()))
				{
					subComments.add(innerComment);
				}	
			}
			comment.setSubComment(subComments);
		}
		
		List<Comment> finalComments=new ArrayList<>(); 
		for (Comment comment : comments) {
			if(comment.getSuper_id().equals("0"))
			{
				finalComments.add(comment);
			}
		}
		for (int i = 0; i < finalComments.size(); i++) {
			System.out.println(finalComments.get(i).getSubComment().size());
		}
		return finalComments;
	}

	/**
	 * 从articles的Content字段读取src属性 将读取的结果复制给article的featureImg属性
	 * @param articles
	 */
	public static void formatImgForArticles(List<Article> articles) {
			for (Article article : articles) {
				String content=article.getContent();
				String[] split1 = content.split(" ");
				for (String str : split1) {
					if(str.startsWith("src"))
					{
						String[] split2 = str.split("\"");
						article.setFeatureImg(split2[1]);
					}
				}
			}
	}


	
	/**
	 * 从articles的Content字段提取文字内容重新赋值给Content
	 * count 表示最多显示字符
	 */
	public static void formatTextForArticles(List<Article> articles,int count) {
		for (Article article : articles) {
			article.setContent(StringUtils.StripHT(article.getContent(),count));
		}
	}
	
	
}
