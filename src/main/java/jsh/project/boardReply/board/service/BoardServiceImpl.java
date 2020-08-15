package jsh.project.boardReply.board.service;

import org.springframework.stereotype.Service;

import jsh.project.boardReply.board.dao.BoardDao;
import jsh.project.boardReply.board.model.domain.Article;
import jsh.project.boardReply.board.model.dto.request.RequestCreateArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestEditArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestRemoveArticleDto;
import jsh.project.boardReply.board.model.dto.response.ResponseArticleDto;
import jsh.project.boardReply.board.model.dto.response.ResponseBoardDto;
import jsh.project.boardReply.board.util.Pagination;

@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public ResponseBoardDto getArticles(int page) {
		Pagination pagination = new Pagination(boardDao.selectArticleTotalCount(), page);
		ResponseBoardDto dto = new ResponseBoardDto();
		dto.setArticles(boardDao.selectArticles(pagination.getSearchScopeMap()));
		dto.setPagination(pagination);
		return dto;
	}

	@Override
	public ResponseArticleDto getArticle(int articleId) {
		return boardDao.selectArticle(articleId);
	}

	@Override
	public int createArticle(RequestCreateArticleDto dto) {
		Article article = dto.toArticle();
		boardDao.insertArticle(article);
		return article.getId();
	}

	@Override
	public int editArticle(RequestEditArticleDto dto) {
		Article article = dto.toArticle();
		boardDao.updateArticle(article);
		return article.getId();
	}

	@Override
	public void removeArticle(RequestRemoveArticleDto dto) {
		//해당 글의 댓글 삭제 필요
		boardDao.deleteArticle(dto.toArticle());
	}

}
