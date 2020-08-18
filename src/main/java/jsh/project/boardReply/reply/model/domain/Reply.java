package jsh.project.boardReply.reply.model.domain;

import java.util.Date;

import jsh.project.boardReply.reply.model.dto.request.RequestCreateReplyDto;
import jsh.project.boardReply.reply.model.dto.request.RequestEditReplyDto;
import jsh.project.boardReply.reply.model.dto.request.RequestRemoveReplyDto;

public class Reply {
	private int id;
	private int articleId;
	private int replyGroup;
	private int replyGroupOrder;
	private int depth;
	private String content;
	private int enabled;
	private Date regdate;
	
	public Reply(RequestCreateReplyDto dto) {
		this.articleId = dto.getArticleId();
		this.replyGroup = dto.getReplyGroup();
		this.replyGroupOrder = dto.getReplyGroupOrder();
		this.depth = dto.getDepth();
		this.content = dto.getContent();
		this.enabled = 1;
		this.regdate = new Date();
	}
	
	public Reply(RequestEditReplyDto dto) {
		this.id = dto.getId();
		this.content = dto.getContent();
	}
	
	public Reply(RequestRemoveReplyDto dto) {
		this.id = dto.getId();
	}

	public int getId() {
		return id;
	}

	public int getArticleId() {
		return articleId;
	}

	public int getReplyGroup() {
		return replyGroup;
	}

	public int getReplyGroupOrder() {
		return replyGroupOrder;
	}

	public int getDepth() {
		return depth;
	}

	public String getContent() {
		return content;
	}

	public int getEnabled() {
		return enabled;
	}

	public Date getRegdate() {
		return regdate;
	}
	
	public interface ReplyConverter{
		Reply toReply();
	}
	
}
