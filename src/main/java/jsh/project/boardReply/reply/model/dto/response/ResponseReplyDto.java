package jsh.project.boardReply.reply.model.dto.response;

import java.util.Date;

public class ResponseReplyDto {
	private int id;
	private int articleId;
	private int replyGroup;
	private int depth;
	private String content;
	private int enabled;
	private Date regdate;
	
	public ResponseReplyDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	

}
