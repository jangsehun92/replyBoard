package jsh.project.boardReply.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jsh.project.boardReply.board.model.domain.Article;
import jsh.project.boardReply.board.model.dto.response.ResponseArticleDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	private SqlSession sqlSession;
	
	public BoardDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int selectArticleTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ResponseArticleDto> selectArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article selectArticle(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

}
