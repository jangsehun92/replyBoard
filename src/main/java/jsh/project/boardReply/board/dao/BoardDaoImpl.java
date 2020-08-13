package jsh.project.boardReply.board.dao;

import java.util.List;
import java.util.Map;

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
		return sqlSession.selectOne("boardMapper.selectTotalCount");
	}

	@Override
	public List<ResponseArticleDto> selectArticles(Map<String,Integer> paramMap) {
		return sqlSession.selectList("boardMapper.selectArticles", paramMap);
	}

	@Override
	public ResponseArticleDto selectArticle(int articleId) {
		return sqlSession.selectOne("boardMapper.selectArticle", articleId);
	}

	@Override
	public void insertArticle(Article article) {
		sqlSession.insert("boardMapper.insertArticle", article);
	}

	@Override
	public void updateArticle(Article article) {
		sqlSession.insert("boardMapper.updateArticle", article);
	}

	@Override
	public void deleteArticle(Article article) {
		sqlSession.insert("boardMapper.deleteArticle", article);
	}

}
