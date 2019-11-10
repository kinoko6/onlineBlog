package top.kinoko6.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import top.kinoko6.pojo.Comment;

public interface CommentMapper {

	
	@Insert("insert into T_comment values(default,#{article_id},#{user_id},#{comment_content},#{comment_date},#{reply_user_id},#{super_id})")
	void insertNewComment(Comment comment);

	
	@Select("select * from T_comment where article_id=#{0}")
	List<Comment> loadArticleCommentsByArticleId(String articleId);

	@Delete("delete from T_comment where article_id=#{0}")
	void deleteCommentByArticleId(String articleId);
}
