package jsh.project.boardReply.reply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jsh.project.boardReply.reply.dao.ReplyDao;
import jsh.project.boardReply.reply.model.domain.Reply;
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
		return replyDao.selectReplys(articleId);
	}

	@Override
	public void createReplys(RequestCreateReplyDto dto) {
		if(dto.getReplyGroup() != 0) {
			dto.setReplyGroupOrder(replyDao.selectGroupOrderCount(dto.getReplyGroup())+1);
			dto.setDepth(1);
		}else {
			dto.setReplyGroup(replyDao.selectGroupCount(dto.getArticleId())+1);
			dto.setReplyGroupOrder(1);
			dto.setDepth(0);
		}
		Reply reply = dto.toReply();
		
		replyDao.insertReplys(reply);
	}

	@Override
	public void editReplys(RequestEditReplyDto dto) {
		replyDao.updateReplys(dto.toReply());
	}

	@Override
	public void removeReplys(RequestRemoveReplyDto dto) {
		replyDao.deleteReplys(dto.toReply());
	}

}
