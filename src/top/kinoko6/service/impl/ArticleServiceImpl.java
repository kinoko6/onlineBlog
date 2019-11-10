package top.kinoko6.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import top.kinoko6.constants.ArticleConstants;
import top.kinoko6.mapper.ArticleMapper;
import top.kinoko6.mapper.UserMapper;
import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.User;
import top.kinoko6.service.ArticleService;
import top.kinoko6.service.UserService;
import top.kinoko6.utils.DateUtils;
import top.kinoko6.utils.PojoUtils;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private UserService userServiceImpl;

	@Override
	public void insertArticle(Article article, HttpSession session) {
		//初始化文章
			article.setUser_id(((User)session.getAttribute("user")).getUser_id());
			article.setClick_sum(0);
			article.setPublish_date(DateUtils.getCurrentTime());
			if(article.getType()==0)
			{
				article.setConcat(null);
				article.setPrice(null);
			}else if(article.getType()==1 || article.getType()==2)
			{
				article.setPrice(null);
			}
			
		//存储文章
			articleMapper.insertArticle(article);
			int id=articleMapper.selectMaxArticleId();
			article.setId(id);
	}

	@Override
	public List<Article> selectArticleListByAuthorId(String authorId) {
		List<Article> articleList=null;
		articleList=articleMapper.selectArticleListByAuthorId(authorId);
		return articleList;
	}

	@Override
	public Article selectArticleById(String articleId) {
		Article  article= articleMapper.selectArticleById(articleId);
		if(article!=null )
		{
			article.setAuthor(userServiceImpl.getUserSessionByIdService(article.getUser_id()));
		}
		return article;
	}

	@Override
	public List<Article> getArticleListByPage(int i) {
		List<Article> articles= articleMapper.getArticleListByPage(i);
		PojoUtils.formatImgForArticles(articles);
		PojoUtils.formatTextForArticles(articles,ArticleConstants.PAGE_MAX_TEXT_COUNTER);
		return articles;
	}

	@Override
	public void deleteArticlesByArticleIds(String[] articleIdArr) {
		for (String id : articleIdArr) {
			deleteArticleById(id);
		}
	} 
	
	public void deleteArticleById(String articleId)
	{
		articleMapper.deleteArticleById(articleId);
	}

	@Override
	public List<Article> filterArticle(String filterDate, String filterType, String authorId) {
		if("全部日期".equals(filterDate)) {
			filterDate=null;
		}
		switch (filterType) {
		case "全部类型":
			filterType=null;
			break;
		case "普通表白":
			filterType="0";
			break;
		case "寻找失物":
			filterType="1";
			break;
		case "招领失物":
			filterType="2";
			break;
		case "闲置物品":
			filterType="3";
			break;
		default:
			filterType=null;
		}
		
		return articleMapper.filterArticle(filterDate, filterType,authorId);
	}

	@Override
	public List<Article> selectSelfArticlesByKeyWords(String keyWord, String authorId) {
		
		return articleMapper.selectSelfArticlesByKeyWords(keyWord,authorId);

	}

	@Override
	public void updateArticle(Article article, String articleId) {
	
		article.setPublish_date(DateUtils.getCurrentTime());
		articleMapper.updateArticle(article,articleId);
		int id=articleMapper.selectMaxArticleId();
		article.setId(id);
	}

	@Override
	public List<Article> geUnusedListByPage(int i) {
		List<Article> articles= articleMapper.getUnusedByPage(i);
		PojoUtils.formatImgForArticles(articles);
		PojoUtils.formatTextForArticles(articles,50);
		return articles;
	}

	@Override
	public List<Article> getTopNByType(int type, int number) {
		List<Article> articles= articleMapper.getTopNByType(type,number);
		PojoUtils.formatImgForArticles(articles);
		return articles;
	}

}
