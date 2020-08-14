package jsh.project.boardReply.board.model.dto.response;

import java.util.List;

import jsh.project.boardReply.board.util.Pagination;

public class ResponseBoardDto {
	// article List
	private List<ResponseArticleDto> articles;
	//pagination
	private	Pagination pagination;
	
	public ResponseBoardDto() {
		
	}
	
	public List<ResponseArticleDto> getArticles() {
		return articles;
	}

	public void setArticles(List<ResponseArticleDto> articles) {
		this.articles = articles;
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
}
