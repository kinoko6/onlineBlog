package top.kinoko6.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import top.kinoko6.pojo.Article;

public interface ArticleService {

	void insertArticle(Article article, HttpSession session);

	List<Article> selectArticleListByAuthorId(String authorId);

	Article selectArticleById(String articleId);

	List<Article> getArticleListByPage(int i);

	void deleteArticlesByArticleIds(String[] articleIdArr);


	List<Article> filterArticle(String filterDate, String filterType, String authorId);

	List<Article> selectSelfArticlesByKeyWords(String keyWord, String authorId);

	void updateArticle(Article article, String articleId);

	List<Article> geUnusedListByPage(int i);

	List<Article> getTopNByType(int i, int j);


}
