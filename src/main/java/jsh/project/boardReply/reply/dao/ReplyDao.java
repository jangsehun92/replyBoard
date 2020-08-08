package jsh.project.boardReply.reply.dao;

import java.util.List;

import jsh.project.boardReply.reply.model.domain.Reply;
import jsh.project.boardReply.reply.model.dto.response.ResponseReplyDto;

public interface ReplyDao {
	public List<ResponseReplyDto> selectReplys(int articleId);
	public void insertReplys(Reply reply);
	public void updateReplys(Reply reply);
	public void deleteReplys(Reply reply);
}
