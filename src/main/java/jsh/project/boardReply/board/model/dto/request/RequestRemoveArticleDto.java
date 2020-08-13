package jsh.project.boardReply.board.model.dto.request;

import jsh.project.boardReply.board.model.domain.Article;
import jsh.project.boardReply.board.model.domain.Article.ArticleConverter;

public class RequestRemoveArticleDto implements ArticleConverter{
	private int id;
	
	public RequestRemoveArticleDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public Article toArticle() {
		return new Article(this);
	}
	
	@Override
	public String toString() {
		return "RequestRemoveArticleDto { id : " + id + " }";
	}

}
