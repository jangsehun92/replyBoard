package jsh.project.boardReply.board.dao;

import java.util.List;

import jsh.project.boardReply.board.domain.Article;

public interface BoardDao {
	public int selectArticleTotalCount();
	public List<Article> selectArticles();
	public Article selectArticle(int articleId);
	public void insertArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Article article);
}
