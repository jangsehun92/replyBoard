package jsh.project.boardReply.board.service;

import java.util.List;

import jsh.project.boardReply.board.domain.Article;

public interface BoardService {
	public List<Article> getArticles();
	public Article getArticle(int articleId);
	public int createArticle();
	public int editArticle();
	public void removeArticle();
}
