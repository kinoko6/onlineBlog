package top.kinoko6.pojo;

import java.util.List;

public class Comment {
	private String id;
	private String article_id;
	private String user_id;
	private String comment_content;
	private String comment_date;
	/**
	 * 
	 * 如果super_id为0 表示对文章的评论
	 * 如果不为0 表示对某一楼下用户之间的评论
	 * 
	 */
	private String super_id;
	/**
	 * 被评论用户的id
	 */
	private String reply_user_id;
	/**
	 * 主评论人的信息
	 */
	private User user;
	/**
	 * 主评论人被评论的信息
	 */
	private User reply_user_info;
	
	private List<Comment> subComment;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	public String getReply_user_id() {
		return reply_user_id;
	}
	public void setReply_user_id(String reply_user_id) {
		this.reply_user_id = reply_user_id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getSubComment() {
		return subComment;
	}
	public void setSubComment(List<Comment> subComment) {
		this.subComment = subComment;
	}
	public String getSuper_id() {
		return super_id;
	}
	public void setSuper_id(String super_id) {
		this.super_id = super_id;
	}
	public User getReply_user_info() {
		return reply_user_info;
	}
	public void setReply_user_info(User reply_user_info) {
		this.reply_user_info = reply_user_info;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article_id == null) ? 0 : article_id.hashCode());
		result = prime * result + ((comment_content == null) ? 0 : comment_content.hashCode());
		result = prime * result + ((comment_date == null) ? 0 : comment_date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reply_user_id == null) ? 0 : reply_user_id.hashCode());
		result = prime * result + ((reply_user_info == null) ? 0 : reply_user_info.hashCode());
		result = prime * result + ((subComment == null) ? 0 : subComment.hashCode());
		result = prime * result + ((super_id == null) ? 0 : super_id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (article_id == null) {
			if (other.article_id != null)
				return false;
		} else if (!article_id.equals(other.article_id))
			return false;
		if (comment_content == null) {
			if (other.comment_content != null)
				return false;
		} else if (!comment_content.equals(other.comment_content))
			return false;
		if (comment_date == null) {
			if (other.comment_date != null)
				return false;
		} else if (!comment_date.equals(other.comment_date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reply_user_id == null) {
			if (other.reply_user_id != null)
				return false;
		} else if (!reply_user_id.equals(other.reply_user_id))
			return false;
		if (reply_user_info == null) {
			if (other.reply_user_info != null)
				return false;
		} else if (!reply_user_info.equals(other.reply_user_info))
			return false;
		if (subComment == null) {
			if (other.subComment != null)
				return false;
		} else if (!subComment.equals(other.subComment))
			return false;
		if (super_id == null) {
			if (other.super_id != null)
				return false;
		} else if (!super_id.equals(other.super_id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", article_id=" + article_id + ", user_id=" + user_id + ", comment_content="
				+ comment_content + ", comment_date=" + comment_date + ", super_id=" + super_id + ", reply_user_id="
				+ reply_user_id + ", user=" + user + ", reply_user_info=" + reply_user_info + ", subComment="
				+ subComment + "]";
	}
	
		
}
