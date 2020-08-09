package jsh.project.boardReply.reply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jsh.project.boardReply.reply.dao.ReplyDao;
import jsh.project.boardReply.reply.model.dto.request.RequestCreateReplyDto;
import jsh.project.boardReply.reply.model.dto.request.RequestEditReplyDto;
import jsh.project.boardReply.reply.model.dto.request.RequestRemoveReplyDto;
import jsh.project.boardReply.reply.model.dto.response.ResponseReplyDto;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyDao replyDao;
	
	public ReplyServiceImpl(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public List<ResponseReplyDto> getReplys(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createReplys(RequestCreateReplyDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editReplys(RequestEditReplyDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeReplys(RequestRemoveReplyDto dto) {
		// TODO Auto-generated method stub
		
	}

}
