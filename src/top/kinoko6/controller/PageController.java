package top.kinoko6.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kinoko6.constants.ArticleConstants;
import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.User;
import top.kinoko6.service.ArticleService;
import top.kinoko6.service.UserService;
import top.kinoko6.service.impl.ArticleServiceImpl;
import top.kinoko6.utils.DateUtils;
import top.kinoko6.utils.PojoUtils;

/**
 * 
 * 负责转发到WEB-INF目录下的jsp文件
 * 
 * @author 童松铅
 * @ClassName: PageController
 * @Description: TODO
 * @date 2019年10月29日
 *
 */

@Controller
public class PageController {

	@Resource
	private ArticleService articleServiceImpl;
	@Resource
	private UserService userServiceImpl;
	//转发到主页面
	@RequestMapping("toMain")
	public String toMain(HttpServletRequest req) {
		List<Article> normalArticles=articleServiceImpl.getTopNByType(0,3);
		normalArticles=userServiceImpl.loadArticleListUserInfos(normalArticles);
		PojoUtils.formatTextForArticles(normalArticles, ArticleConstants.PAGE_MAX_TEXT_COUNTER);
		List<Article> lostArticles=articleServiceImpl.getTopNByType(1,8);
		lostArticles=userServiceImpl.loadArticleListUserInfos(lostArticles);
		PojoUtils.formatTextForArticles(lostArticles, 15);
		List<Article> findArticles=articleServiceImpl.getTopNByType(2,8);
		findArticles=userServiceImpl.loadArticleListUserInfos(findArticles);
		PojoUtils.formatTextForArticles(findArticles, 15);
		
		req.setAttribute("normalArticles", normalArticles);
		req.setAttribute("lostArticles", lostArticles);
		req.setAttribute("findArticles", findArticles);
		return "index";
	}
	
	//转发到用户信息界面
	@RequestMapping("userPage")	
	public String toUserPage()
	{
		return "person_info";
	}
	//转发到新增文章界面
	@RequestMapping("newArticle")
	public String toNewArticle()
	{
		return "new_article";
	}
	//转发到文章界面
	@RequestMapping("article")
	public String toArticle(HttpSession session)
	{
		if(session.getAttribute("article")==null)
			return "redirect:toMain";
		return "single_article";
	}
	//转发到文章列表界面
	@RequestMapping("articleList")
	public String toArticleList(HttpSession session)
	{
		List<Article> articleList;
		if (session.getAttribute(ArticleConstants.SESSION_ARTICLE_LIST)==null)
		{
			String authorId=((User)session.getAttribute("user")).getUser_id();
			articleList=articleServiceImpl.selectArticleListByAuthorId(authorId);
			session.setAttribute(ArticleConstants.SESSION_ARTICLE_LIST, articleList);
		}
		articleList=(List<Article>) session.getAttribute(ArticleConstants.SESSION_ARTICLE_LIST);
		List<String> dateSet = DateUtils.distinctDateForArticles(articleList);
		session.setAttribute(ArticleConstants.SESSION_ARTICLE_LIST_DATE_SET, dateSet);
		return "article_list";
	}
	
	//转发到表白墙
	@RequestMapping("loveWall")
	public String toLoveWall(HttpServletRequest req)
	{
		List<Article> articles=articleServiceImpl.getArticleListByPage(0);
		articles=userServiceImpl.loadArticleListUserInfos(articles);
		req.setAttribute("articles", articles);
		return "love_wall";
	}
	
	//转发到闲置物品
	@RequestMapping("unused")
	public String toUnUsed(HttpServletRequest req)
	{
		List<Article> articles=articleServiceImpl.geUnusedListByPage(0);
		articles=userServiceImpl.loadArticleListUserInfos(articles);
		req.setAttribute("articles", articles);
		return "unused_things";
	}
	
	//转发到主页
	@RequestMapping("/")
	public String toMain() {
		return "forward:toMain";
	}
}
