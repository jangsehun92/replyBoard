package jsh.project.boardReply.reply.model.dto.request;

import jsh.project.boardReply.reply.model.domain.Reply;
import jsh.project.boardReply.reply.model.domain.Reply.ReplyConverter;

public class RequestRemoveReplyDto implements ReplyConverter{
	private int id;
	
	public RequestRemoveReplyDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Reply toReply() {
		return new Reply(this);
	}
}
