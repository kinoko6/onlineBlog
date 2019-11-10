package top.kinoko6.constants;

public interface ArticleConstants {
	
	
	/**
	 * 文章类型
	 */
	int ARTICLE_TYPE_NORAML=0;
	int ARTICLE_TYPE_LOST=1;
	int ARTICLE_TYPE_FOUND=2;
	int ARTICLE_TYPE_UNUSED=3;

	
	/**
	 * 文章
	 */
	String ARTICLE_IMG_SAVE_PATH="upload/article/";
	
	/**
	 * Session常量
	 * 
	 */
	String SESSION_ARTICLE_LIST="articleList";
	String SESSION_SINGLE_ARTICLE="article";
	String SESSION_ARTICLE_LIST_DATE_SET = "dateSet";
	
	/**
	 * 每页显示的数量
	 */
	int PAGE_SIEZ=5;
	/**
	 * 
	 * 每页最多显示文字数
	 */
	int PAGE_MAX_TEXT_COUNTER=300;
	String REQUEST_ARTICLE_TOBE_EDIT = "articleToBeEdit";
	
}
