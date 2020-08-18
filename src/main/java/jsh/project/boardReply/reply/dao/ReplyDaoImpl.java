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
		return sqlSession.selectList("selectReplys",articleId);
	}
	
	@Override
	public int selectGroupCount(int articleId) {
		return sqlSession.selectOne("selectGroupCount",articleId);
	}
	
	@Override
	public int selectGroupOrderCount(int group) {
		return sqlSession.selectOne("selectGroupOrderCount", group);
	}

	@Override
	public void insertReplys(Reply reply) {
		sqlSession.insert("insertReply",reply);
		
	}

	@Override
	public void updateReplys(Reply reply) {
		sqlSession.update("updateReply",reply);
	}

	@Override
	public void deleteReplys(Reply reply) {
		sqlSession.update("deleteReply",reply);
	}


}
