package jsh.project.boardReply.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jsh.project.boardReply.board.model.dto.request.RequestArticlesDto;
import jsh.project.boardReply.board.service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/")
	public String root() {
		return "home";
	}
	
	// 게시글 리스트 가져오기
	@GetMapping("/board/{page}")
	public String articleList(@PathVariable("page") int page, Model model) {
		model.addAttribute("articles",boardService.getArticles(page));
		return "";
	}
	
	// 단일 게시글 가져오기
	
	// 게시글 입력 페이지 요청
	
	// 게시글 입력
	
	// 게시글 수정 페이지 요청 
	
	// 게시글 수정
	
	// 게시글 삭제 

}
