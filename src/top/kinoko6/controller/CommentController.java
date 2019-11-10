package top.kinoko6.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kinoko6.pojo.Article;
import top.kinoko6.pojo.Comment;
import top.kinoko6.service.CommentService;

@Controller
public class CommentController {

	@Resource
	private CommentService commentServiceImpl;
	
	//发表新评论
	@RequestMapping("newComment")
	public String newComment(Comment comment,HttpSession session)
	{
		commentServiceImpl.insertNewComment(comment);
		session.setAttribute("articleId", comment.getArticle_id());
		return "redirect:viewArticle";
	}
	
}
