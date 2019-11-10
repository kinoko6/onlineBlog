package top.kinoko6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import top.kinoko6.pojo.Article;

public interface ArticleMapper {

	
	@Insert("insert into T_article values(default,#{user_id},#{type},#{theme},#{content},#{concat},#{price},#{publish_date},#{click_sum})")
	void insertArticle(Article article);

	@Select("select * from T_article   where user_id=#{0} order by publish_date desc")
	List<Article> selectArticleListByAuthorId(String authorId);
	
	@Select("select * from T_article where id=#{0}")
	Article selectArticleById(String articleId);

	@Select("select * from T_article order by publish_date desc  limit #{i}, 5 ")
	List<Article> getArticleListByPage(int i);

	@Select("select max(id) from T_article")
	int selectMaxArticleId();

	@Delete("delete from T_article where id=#{0}")
	void deleteArticleById(String articleId);


	List<Article> filterArticle(@Param("filterDate") String filterDate,@Param("filterType")  String filterType,@Param("authorId")  String authorId);

	List<Article> selectSelfArticlesByKeyWords(@Param("KeyWord")String keyWord,@Param("authorId") String authorId);

	void updateArticle(@Param("article")Article article,@Param("articleId") String articleId);

	@Select("select * from T_article where type=3 order by publish_date desc  limit #{i}, 8 ")
	List<Article> getUnusedByPage(int i);

	@Select("select * from T_article where type=#{arg0} order by publish_date desc  limit #{arg1}")
	List<Article> getTopNByType(int type, int number);

}
