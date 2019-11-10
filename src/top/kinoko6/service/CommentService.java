package top.kinoko6.service;

import java.util.List;

import top.kinoko6.pojo.Comment;

public interface CommentService {

	void insertNewComment(Comment comment);

	List<Comment> loadArticleCommentsByArticleId(String articleId);

	void deleteCommentsByArticleIds(String[] articleIdArr);

}
