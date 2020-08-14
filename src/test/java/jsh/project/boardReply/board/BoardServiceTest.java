package jsh.project.boardReply.board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jsh.project.boardReply.board.dao.BoardDao;
import jsh.project.boardReply.board.model.dto.response.ResponseArticleDto;
import jsh.project.boardReply.board.model.dto.response.ResponseBoardDto;
import jsh.project.boardReply.board.service.BoardService;
import jsh.project.boardReply.board.service.BoardServiceImpl;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BoardServiceTest {

	@InjectMocks
	private BoardServiceImpl boardService;

	@Mock
	private BoardDao boardDao;

	@Test
	public void 단일_게시글_가져오기() {
		// given
		int articleId = 12;
		
		ResponseArticleDto responseArticleDto = new ResponseArticleDto();
		responseArticleDto.setId(12);
		responseArticleDto.setTitle("test_title");
		responseArticleDto.setContent("test_content");
		responseArticleDto.setReplyCount(0);
		responseArticleDto.setRegdate(new Date());
		
		given(boardDao.selectArticle(articleId)).willReturn(responseArticleDto);
		
		// when
		ResponseArticleDto dto = boardService.getArticle(articleId);

		// then
		verify(boardDao, times(1)).selectArticle(articleId);
		assertThat(dto.getId(), is(12));
	}

	@Test
	public void 게시글_범위만큼_가져오기() {
		// given
		int page = 1;
		given(boardDao.selectArticleTotalCount()).willReturn(11);
		
		// when
		ResponseBoardDto dto = boardService.getArticles(page);
		
		// then
		verify(boardDao, times(1)).selectArticles(any());
		assertThat(dto.getPagination().getTotalPage(), is(2));
	}

	@Test
	public void 게시글_입력() {
		// given

		// when

		// then

	}

	@Test
	public void 게시글_수정() {
		// given

		// when

		// then

	}

	@Test
	public void 게시글_삭제() {
		// given

		// when

		// then

	}

}
