package kim.kim.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kim.kim.service.MemberService;
import kim.kim.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger =LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	//회원가입 GET
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public void getRegister() throws Exception{
		logger.info("get register");
	}
	
	//회원가입 POST
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception{
		logger.info("post register");
		
		service.register(vo);
		
		return null;
	}
	
	
	
	

}
