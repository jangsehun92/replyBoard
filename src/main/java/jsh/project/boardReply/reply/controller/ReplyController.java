package jsh.project.boardReply.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jsh.project.boardReply.reply.model.dto.response.ResponseReplyDto;
import jsh.project.boardReply.reply.service.ReplyService;

@Controller
public class ReplyController {
	
	private ReplyService replyService;
	
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	// Reply List 요청
	@GetMapping("/reply/{articleId}")
	public ResponseEntity<List<ResponseReplyDto>> replyList(@PathVariable("articleId") int articleId){
		return new ResponseEntity<List<ResponseReplyDto>>(replyService.getReplys(articleId), HttpStatus.OK);
	}
	// Reply 쓰기 
	
	// Reply 수정
	
	// Reply 삭제
}
