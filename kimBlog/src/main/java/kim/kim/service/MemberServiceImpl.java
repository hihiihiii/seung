package kim.kim.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kim.kim.dao.MemberDAO;
import kim.kim.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject 
	MemberDAO dao;
	
	//회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

}
