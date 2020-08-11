package jsh.project.boardReply.board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import jsh.project.boardReply.board.dao.BoardDaoImpl;
import jsh.project.boardReply.board.model.dto.response.ResponseArticleDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-contextTest.xml")
@Transactional(transactionManager = "transactionManager")
public class BoardDaoTest {
	private static final Logger log = LoggerFactory.getLogger(BoardDaoTest.class);
	
	@Autowired
	private BoardDaoImpl boardDao;
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void 게시글_총_갯수_가져오기() {
		//given
		int totalCount = 0;
		
		//when
		totalCount = boardDao.selectArticleTotalCount();
		
		//then
		assertThat(totalCount, is(56));
	}
	
	@Test
	public void 게시글_리스트_가져오기() {
		//given
		Map<String,Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("startCount", 0);
		paramMap.put("endCount",10);
		
		//when
		List<ResponseArticleDto> articls  = boardDao.selectArticles(paramMap);
		
		//then
		assertNotNull(articls);
	}
	
	@Test
	public void 게시글_입력() {
		//given
		
		//when
		
		//then
	}
	
	@Test
	public void 게시글_수정() {
		//given
		
		//when
		
		//then
	}
	
	@Test
	public void 게시글_삭제() {
		//given
		
		//when
		
		//then
	}
	
}
