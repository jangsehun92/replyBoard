package jsh.project.boardReply.board.dao;

import java.util.List;
import java.util.Map;

import jsh.project.boardReply.board.model.domain.Article;
import jsh.project.boardReply.board.model.dto.response.ResponseArticleDto;

public interface BoardDao {
	public int selectArticleTotalCount();
	public List<ResponseArticleDto> selectArticles(Map<String,Integer> paramMap);
	public Article selectArticle(int articleId);
	public void insertArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Article article);
}
