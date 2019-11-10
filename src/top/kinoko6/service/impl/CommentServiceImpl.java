package top.kinoko6.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.kinoko6.mapper.CommentMapper;
import top.kinoko6.pojo.Comment;
import top.kinoko6.service.CommentService;
import top.kinoko6.utils.DateUtils;


@Service
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentMapper commentMapper;

	@Override
	public void insertNewComment(Comment comment) {
		comment.setComment_date(DateUtils.getCurrentTime());
		commentMapper.insertNewComment(comment);
	}

	@Override
	public List<Comment> loadArticleCommentsByArticleId(String articleId) {
		return commentMapper.loadArticleCommentsByArticleId(articleId);
	}

	@Override
	public void deleteCommentsByArticleIds(String[] articleIdArr) {
			for (String id : articleIdArr) {
				deleteCommentByArticleId(id);
			}
	}

	private void deleteCommentByArticleId(String articleId) {
		commentMapper.deleteCommentByArticleId(articleId);
	}
	
}
