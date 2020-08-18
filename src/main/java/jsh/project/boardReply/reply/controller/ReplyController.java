package jsh.project.boardReply.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jsh.project.boardReply.reply.model.dto.request.RequestCreateReplyDto;
import jsh.project.boardReply.reply.model.dto.request.RequestEditReplyDto;
import jsh.project.boardReply.reply.model.dto.request.RequestRemoveReplyDto;
import jsh.project.boardReply.reply.model.dto.response.ResponseReplyDto;
import jsh.project.boardReply.reply.service.ReplyService;

@Controller
public class ReplyController {
	
	private ReplyService replyService;
	
	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	// Reply List 요청
	@GetMapping("/replys/{articleId}")
	public ResponseEntity<List<ResponseReplyDto>> replyList(@PathVariable("articleId") int articleId){
		return new ResponseEntity<List<ResponseReplyDto>>(replyService.getReplys(articleId), HttpStatus.OK);
	}
	// Reply 쓰기 
	
	@PostMapping("/reply")
	public ResponseEntity<HttpStatus> createReply(@RequestBody RequestCreateReplyDto dto){
		replyService.createReplys(dto);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	// Reply 수정
	@PatchMapping("/reply/{id}")
	public ResponseEntity<HttpStatus> editReply(@PathVariable("id") int id, @RequestBody RequestEditReplyDto dto){
		replyService.editReplys(dto);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	// Reply 삭제
	@DeleteMapping("/reply/{id}")
	public ResponseEntity<HttpStatus> removeReply(@PathVariable("id") int id, RequestRemoveReplyDto dto){
		replyService.removeReplys(dto);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
