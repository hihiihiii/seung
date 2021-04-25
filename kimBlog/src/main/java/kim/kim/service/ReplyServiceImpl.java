package kim.kim.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kim.kim.dao.ReplyDAO;
import kim.kim.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	ReplyDAO dao;

	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		
		return dao.readReply(bno);
	}
	
}
