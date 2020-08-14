package jsh.project.boardReply.board.service;

import jsh.project.boardReply.board.model.dto.request.RequestCreateArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestEditArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestRemoveArticleDto;
import jsh.project.boardReply.board.model.dto.response.ResponseArticleDto;
import jsh.project.boardReply.board.model.dto.response.ResponseBoardDto;

public interface BoardService {
	public ResponseBoardDto getArticles(int page);
	public ResponseArticleDto getArticle(int articleId);
	public int createArticle(RequestCreateArticleDto dto);
	public int editArticle(RequestEditArticleDto dto);
	public void removeArticle(RequestRemoveArticleDto dto);
}
