package jsh.project.boardReply.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jsh.project.boardReply.reply.model.domain.Reply;
import jsh.project.boardReply.reply.model.dto.response.ResponseReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao{
	
	private final SqlSession sqlSession;
	
	public ReplyDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ResponseReplyDto> selectReplys(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertReplys(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReplys(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReplys(Reply reply) {
		// TODO Auto-generated method stub
		
	}

}
