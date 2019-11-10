package top.kinoko6.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Article implements Serializable{
	private int id;
	private String user_id;
	private int type;
	private String theme;
	private String content;
	private String concat;
	private Double price;
	private String publish_date;
	private int click_sum;
	private String featureImg;
	

	//额外信息
	private User author;
	/**
	 *	评论信息
	 */
	private List<Comment> comments;

	
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getFeatureImg() {
		return featureImg;
	}
	public void setFeatureImg(String featureImg) {
		this.featureImg = featureImg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getConcat() {
		return concat;
	}
	public void setConcat(String concat) {
		this.concat = concat;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public int getClick_sum() {
		return click_sum;
	}
	public void setClick_sum(int click_sum) {
		this.click_sum = click_sum;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", user_id=" + user_id + ", type=" + type + ", theme=" + theme + ", content="
				+ content + ", concat=" + concat + ", price=" + price + ", publish_date=" + publish_date
				+ ", click_sum=" + click_sum + ", featureImg=" + featureImg + ", author=" + author + ", comments="
				+ comments + "]";
	}

	
}
