package kim.kim.dao;

import java.util.List;

import kim.kim.vo.ReplyVO;

public interface ReplyDAO {
	
		public List<ReplyVO> readReply(int bno) throws Exception;

}
