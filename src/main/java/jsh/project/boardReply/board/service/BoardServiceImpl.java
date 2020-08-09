package jsh.project.boardReply.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jsh.project.boardReply.board.dao.BoardDao;
import jsh.project.boardReply.board.model.domain.Article;

@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticle(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeArticle() {
		// TODO Auto-generated method stub
		
	}

}
