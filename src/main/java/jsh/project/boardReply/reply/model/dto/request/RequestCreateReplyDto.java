package jsh.project.boardReply.reply.model.dto.request;

import jsh.project.boardReply.reply.model.domain.Reply;
import jsh.project.boardReply.reply.model.domain.Reply.ReplyConverter;

public class RequestCreateReplyDto implements ReplyConverter{
	private int articleId;
	private int replyGroup;
	private int replyGroupOrder;
	private int depth;
	private String content;
	
	public RequestCreateReplyDto() {
		
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getReplyGroup() {
		return replyGroup;
	}

	public void setReplyGroup(int replyGroup) {
		this.replyGroup = replyGroup;
	}
	
	public int getReplyGroupOrder() {
		return replyGroupOrder;
	}

	public void setReplyGroupOrder(int replyGroupOrder) {
		this.replyGroupOrder = replyGroupOrder;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
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
