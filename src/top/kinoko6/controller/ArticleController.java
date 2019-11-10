package top.kinoko6.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.kinoko6.constants.ArticleConstants;
import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.Comment;
import top.kinoko6.pojo.User;
import top.kinoko6.service.ArticleService;
import top.kinoko6.service.CommentService;
import top.kinoko6.service.UserService;
import top.kinoko6.service.impl.ArticleServiceImpl;
import top.kinoko6.utils.PojoUtils;
import top.kinoko6.utils.StringUtils;

@Controller
public class ArticleController {

	@Resource
	private ArticleService articleServiceImpl;
	@Resource
	private CommentService commentServiceImpl;
	@Resource
	private UserService userServiceImpl;
	//保存用户上传到服务器的图片
	@RequestMapping("uploadImage")
	@ResponseBody
	public String dealImg(@RequestParam("upload") MultipartFile[] file, HttpServletRequest request,HttpServletResponse response,String CKEditorFuncNum) throws IOException
	{
		   StringBuffer sb=new StringBuffer();
		    // 获取文件名
		for (int i=0;i<file.length;i++) {
			 String fileName = file[i].getOriginalFilename();
			    // 获取文件的后缀名
			    String suffixName = fileName.substring(fileName.lastIndexOf("."));
			    String newFileName=StringUtils.getUUID()+suffixName;
				FileUtils.copyInputStreamToFile(file[i].getInputStream(), new File(request.getServletContext().getRealPath(ArticleConstants.ARTICLE_IMG_SAVE_PATH)+newFileName));
			    sb.append("<script type=\"text/javascript\">");
			    sb.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" +ArticleConstants.ARTICLE_IMG_SAVE_PATH+ newFileName + "','')");
			    sb.append("</script>");
		}
		    return sb.toString();
	}
	
	/**
	 * 发布文章或修改
	 * 
	 * @param article	
	 * @param oper		0 表示新增文章  1表示修改文章
	 * @param articleId		表示修改文章的id   如果是新增文章id<0
	 * @param session
	 * @return
	 */
	@RequestMapping("publishNewArticle")
	public String newArticle(Article article,String oper,String articleId,HttpSession session)
	{
		
		//0表示新增文章   否则是修改文章
		if(oper.equals("0"))
		{
			//文章入库
			articleServiceImpl.insertArticle(article,session);
		}else {
			articleServiceImpl.updateArticle(article,articleId);
		}

		//加载文章作者信息
		article.setAuthor((User)session.getAttribute("user"));
		session.setAttribute("article", article);
		//清除session中的缓存
		session.removeAttribute(ArticleConstants.SESSION_ARTICLE_LIST);
		//转发到文章界面
		return "redirect:article";
	}
	
	//查看文章
	@RequestMapping("viewArticle")
	public String viewArticle(String articleId,HttpSession session)
	{
		if(StringUtils.isEmpty(articleId))
		{
			articleId=String.valueOf(((Article) session.getAttribute("article")).getId());
			if (StringUtils.isEmpty(articleId)) {
				articleId=(String) session.getAttribute("articleId");
			}
		}
		Article article=articleServiceImpl.selectArticleById(articleId);
		//加载文章的评论
		List<Comment> comments=commentServiceImpl.loadArticleCommentsByArticleId(articleId);
		//加载评论文章的用户
		comments=userServiceImpl.loadCommentsUsers(comments);
		//根据直接评论和间接评论对评论信息做装配
		List<Comment> organizeCommnets = PojoUtils.organizeCommnets(comments);
		article.setComments(organizeCommnets);
		session.setAttribute("article", article);
		return "forward:article";
	}
	//加载更多的文章  以json格式响应
	@RequestMapping("loadMoreArticleByPage")
	@ResponseBody
	public List<Article> loadMoreArticle(int pageNumber)
	{
		pageNumber*=5;
		List<Article> articles=articleServiceImpl.getArticleListByPage(pageNumber);
		articles = userServiceImpl.loadArticleListUserInfos(articles);
		return articles;
	}
	//加载更多闲置物品  以json格式响应
	@RequestMapping("loadMoreUnusedByPage")
	@ResponseBody
	public List<Article> loadMoreUnusedByPage(int pageNumber)
	{
		pageNumber*=8;
		List<Article> articles=articleServiceImpl.geUnusedListByPage(pageNumber);
		articles = userServiceImpl.loadArticleListUserInfos(articles);
		return articles;
	}
	//删除文章  可以批量删除
	@RequestMapping("deleteArticle")
	public String deleteArticle(String articleIds,HttpSession session)
	{
		String[] articleIdArr = articleIds.split(",");
		if(articleIdArr.length>=0) {
			//删除文章
			articleServiceImpl.deleteArticlesByArticleIds(articleIdArr);
			//删除评论
			commentServiceImpl.deleteCommentsByArticleIds(articleIdArr);
		}
		session.removeAttribute(ArticleConstants.SESSION_ARTICLE_LIST);
		return "redirect:articleList";
	}
	
	/**
	 * 筛选文章
	 * 两个维度：
	 * 		日期：2019-9
	 * 		文章类型：普通表白/寻找失物/招领失物/闲置物品	
	 */
	@RequestMapping("filterArticle")
	public String filterArticle(String filterDate,String filterType,HttpSession session)
	{
		String authorId = ((User) session.getAttribute("user")).getUser_id();
		List<Article> articles =articleServiceImpl.filterArticle(filterDate,filterType,authorId);
		session.setAttribute(ArticleConstants.SESSION_ARTICLE_LIST, articles);
		return "redirect:articleList";
	}
	
	/**
	 * 查找用户自己的文章
	 *		 keyWord：用户在搜索框输入的内容
	 */
	@RequestMapping("searchSelfArticles")
	public String searchSelfArticles(String keyWord,HttpSession session)
	{
		String authorId = ((User)session.getAttribute("user")).getUser_id();
		List<Article> articleList=articleServiceImpl.selectSelfArticlesByKeyWords(keyWord,authorId);
		session.setAttribute(ArticleConstants.SESSION_ARTICLE_LIST, articleList);
		return "redirect:articleList";
	}
	
	/**
	 * 修改文章
	 */
	@RequestMapping("editArticle")
	public String editArticle(String articleId,HttpServletRequest req)
	{
		Article article = articleServiceImpl.selectArticleById(articleId);
		req.setAttribute(ArticleConstants.REQUEST_ARTICLE_TOBE_EDIT, article);
		req.setAttribute("oper", 1);
		return "forward:newArticle";
	}
}
