package jsh.project.boardReply.board.model.dto.request;

import jsh.project.boardReply.board.model.domain.Article;
import jsh.project.boardReply.board.model.domain.Article.ArticleConverter;

public class RequestEditArticleDto implements ArticleConverter {
	private int id;
	private String title;
	private String content;
	
	public RequestEditArticleDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public Article toArticle() {
		return new Article(this);
	}
	
	@Override
	public String toString() {
		return "RequestEditArticleDto { id : " + id + " title : " + title + " content : " + content + " }";
	}
	

}
