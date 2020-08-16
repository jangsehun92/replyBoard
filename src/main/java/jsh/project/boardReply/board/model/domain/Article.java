package jsh.project.boardReply.board.model.domain;

import java.util.Date;

import jsh.project.boardReply.board.model.dto.request.RequestCreateArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestEditArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestRemoveArticleDto;

public class Article {
	private int id;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	public Article(RequestCreateArticleDto dto) {
		this.writer = dto.getWriter();
		this.title = dto.getTitle();
		this.content = dto.getContent();
		this.regdate = new Date();
	}
	
	public Article(RequestEditArticleDto dto) {
		this.id = dto.getId();
		this.title = dto.getTitle();
		this.content = dto.getContent();
	}
	
	public Article(RequestRemoveArticleDto dto) { 
		this.id = dto.getId();
	}

	public int getId() {
		return id;
	}
	
	public String getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getRegdate() {
		return regdate;
	}
	
	@Override
	public String toString() {
		return "Article { id : " + id + " writer : + " + writer + " title : " + title + " content : " + content + " regdate : " + regdate + " }";
	}
	
	public interface ArticleConverter{
		Article toArticle();
	}
	
}

