package jsh.project.boardReply.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "redirect:/articles/1";
	}
	
	// 게시글 리스트 가져오기
	@GetMapping("/articles/{page}")
	public String articleList(@PathVariable("page") int page, Model model) {
		model.addAttribute("responseBoardDto",boardService.getArticles(page));
		return "articlePages/articles";
	}
	
	// 단일 게시글 가져오기
	@GetMapping("/article/{articleId}")
	public String article(@PathVariable("articleId") int articleId, Model model) {
		model.addAttribute("responseArticleDto",boardService.getArticle(articleId));
		return "articlePages/articleDetail";
	}
	
	// 게시글 입력 페이지 요청
	@GetMapping("/article/create")
	public String articleCreatePage() {
		return "articlePages/articleCreatePage";
	}
	
	// 게시글 입력
	
	// 게시글 수정 페이지 요청 
	@GetMapping("/article/edit/{articleId}")
	public String articleEditPage(@PathVariable("articleId") int articleId, Model model) {
		model.addAttribute("responseArticleDto", boardService.getArticle(articleId));
		return "articlePages/articleEditPage";
	}
	
	// 게시글 수정
	
	// 게시글 삭제 
	

}
