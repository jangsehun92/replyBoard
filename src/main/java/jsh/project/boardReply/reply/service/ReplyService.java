package jsh.project.boardReply.reply.service;

import java.util.List;

import jsh.project.boardReply.reply.dto.request.RequestCreateReplyDto;
import jsh.project.boardReply.reply.dto.request.RequestEditReplyDto;
import jsh.project.boardReply.reply.dto.request.RequestRemoveReplyDto;
import jsh.project.boardReply.reply.dto.response.ResponseReplyDto;

public interface ReplyService {
	public List<ResponseReplyDto> getReplys(int articleId);
	public void createReplys(RequestCreateReplyDto dto);
	public void editReplys(RequestEditReplyDto dto);
	public void removeReplys(RequestRemoveReplyDto dto);
}
