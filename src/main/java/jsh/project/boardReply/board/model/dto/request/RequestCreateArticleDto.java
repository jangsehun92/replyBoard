package jsh.project.boardReply.board.model.dto.request;

import jsh.project.boardReply.board.model.domain.Article;
import jsh.project.boardReply.board.model.domain.Article.ArticleConverter;

public class RequestCreateArticleDto implements ArticleConverter{
	private String writer;
	private String title;
	private String content;
	
	public RequestCreateArticleDto() {
		
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
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
		return "RequestCreateArticleDto { writer : " + writer + " + title : + " + title + " content : " + content + " }";
	}

}
