package jsh.project.boardReply.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jsh.project.boardReply.board.model.dto.request.RequestCreateArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestEditArticleDto;
import jsh.project.boardReply.board.model.dto.request.RequestRemoveArticleDto;
import jsh.project.boardReply.board.service.BoardService;

@Controller
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/articles?page=1";
	}
	
	// 게시글 리스트 가져오기
	@GetMapping("/articles")
	public String articleList(int page, Model model) {
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
	@PostMapping("/article")
	public ResponseEntity<Integer> articleCreate(@RequestBody RequestCreateArticleDto dto){
		return new ResponseEntity<Integer>(boardService.createArticle(dto), HttpStatus.OK);
	}
	
	// 게시글 수정 페이지 요청 
	@GetMapping("/article/edit/{articleId}")
	public String articleEditPage(@PathVariable("articleId") int articleId, Model model) {
		model.addAttribute("responseArticleDto", boardService.getArticle(articleId));
		return "articlePages/articleEditPage";
	}
	
	// 게시글 수정
	@PatchMapping("/article/{articleId}")
	public ResponseEntity<HttpStatus> articleEdit(@PathVariable("articleId") int articleId, @RequestBody RequestEditArticleDto dto){
		boardService.editArticle(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 게시글 삭제 
	@DeleteMapping("/article/{id}")
	public ResponseEntity<HttpStatus> articleRemove(@PathVariable("id") int articleId, RequestRemoveArticleDto dto){
		dto.setId(articleId);
		boardService.removeArticle(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
