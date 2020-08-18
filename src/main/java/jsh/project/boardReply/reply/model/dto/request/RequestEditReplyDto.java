package jsh.project.boardReply.reply.model.dto.request;

import jsh.project.boardReply.reply.model.domain.Reply;
import jsh.project.boardReply.reply.model.domain.Reply.ReplyConverter;

public class RequestEditReplyDto implements ReplyConverter{
	private int id;
	private String content;
	
	public RequestEditReplyDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public Reply toReply() {
		return new Reply(this);
	}
	
}
