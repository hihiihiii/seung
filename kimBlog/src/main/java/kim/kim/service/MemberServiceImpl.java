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

	//로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}

	//회원수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		dao.memberUpdate(vo);
		
	}

	//회원탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		dao.memberDelete(vo);
		
	}

	
	//패스워드체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = dao.passChk(vo);
		return result;
	}

	//아이디중복체크
	@Override
	public int idChk(MemberVO vo) throws Exception {
		int result = dao.idChk(vo);
		return result;
	}

}
