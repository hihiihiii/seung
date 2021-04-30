package kim.kim.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kim.kim.service.BoardService;
import kim.kim.service.ReplyService;
import kim.kim.vo.BoardVO;
import kim.kim.vo.PageMaker;
import kim.kim.vo.ReplyVO;
import kim.kim.vo.SearchCriteria;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;
	
	@Inject
	ReplyService replyService;

	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {
		logger.info("writeView");

	}

	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		logger.info("write");

		service.write(boardVO);

		return "redirect:/board/list";
	}

	/*
	 * BoardController로 들어와서 URL은 /list로 정하고 오라클 > 다오 > 서비스 > 컨트롤러로 가져온 데이터들을 jsp에
	 * 뿌려주는 작업을 해야 합니다. model은 데이터를 담을 그릇이고 addAttribute("list", service.list())는
	 * service.list()에 담긴 데이터를 "list"라는 이름으로 담을것이다 라는 뜻으로 해석하시면됩니다.
	 */

	// 게시판 목록 조회
	@RequestMapping(value = "board/list", method = RequestMethod.GET)
	public String list(Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("list");

		model.addAttribute("list", service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker",pageMaker);

		return "board/list";
	}

	// 게시판 조회
	@RequestMapping(value = "board/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("read");
		// 서비스 read boardVO에 있는 bno를 가져온다.
		model.addAttribute("read", service.read(boardVO.getBno()));
		model.addAttribute("scri", scri);
		
		List<ReplyVO> replyList = replyService.readReply(boardVO.getBno());
		model.addAttribute("replyList",replyList);

		return "board/readView";
	}

	// 게시판 수정뷰
	@RequestMapping(value = "board/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO,@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("updateView");

		model.addAttribute("update", service.read(boardVO.getBno()));
		model.addAttribute("scri", scri);

		return "board/updateView";
	}

	// 게시판 수정
	@RequestMapping(value = "board/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO,@ModelAttribute("scri") SearchCriteria scri,RedirectAttributes rttr) throws Exception {
		logger.info("update");

		service.update(boardVO); 
		
		rttr.addAttribute("page",scri.getPage());
		rttr.addAttribute("perPageNum",scri.getPerPageNum());
		rttr.addAttribute("searchType",scri.getSearchType());
		rttr.addAttribute("keyword",scri.getKeyword());

		return "redirect:/board/list";
	}

	// 게시판 삭제
	@RequestMapping(value = "board/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO,@ModelAttribute("scri") SearchCriteria scri,RedirectAttributes rttr) throws Exception {
		logger.info("delete");

		service.delete(boardVO.getBno());
		
		rttr.addAttribute("page",scri.getPage());
		rttr.addAttribute("perPageNum",scri.getPerPageNum());
		rttr.addAttribute("searchType",scri.getSearchType());
		rttr.addAttribute("keyword",scri.getKeyword());

		return "redirect:/board/list";
	}
	
	
	/*
	 * BoardController.java에서 댓글 작성을 위한 메서드를 만들어줍니다. 파라미터로 ReplyVO, SearchCriteria,
	 * RedirectAttributes를 넣어주었는데요. ReplyVO는 댓글 작성하기위한 데이터, SearchCriteria는
	 * readView에 있던 page, perPageNum, searchType, keyword값을 받아오기 위한것이고요.
	 * RedirectAttributes는 redirect했을때 값들을 물고 이동합니다. 그래서 SearchCriteria의 값을 넣어서 댓글을
	 * 저장 한 뒤 원래 페이지로 redirect하여 이동하게 됩니다.
	 */
	
	//댓글작성 컨트롤러
	@RequestMapping(value="board/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVO vo, SearchCriteria scri,RedirectAttributes rttr) throws Exception{
		logger.info("reply Write");
		
		replyService.writeReply(vo);
		
		rttr.addAttribute("bno",vo.getBno());
		rttr.addAttribute("page",scri.getPage());
		rttr.addAttribute("perPageNum",scri.getPerPageNum());
		rttr.addAttribute("searchType",scri.getSearchType());
		rttr.addAttribute("keyword",scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	//댓글 수정 GET
	@RequestMapping(value="board/replyUpdateView", method= RequestMethod.GET)
	public String replyUpdateView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception{
		logger.info("reply Write");
		
		model.addAttribute("replyUpdate", replyService.selectReply(vo.getRno()));
		model.addAttribute("scri",scri);

		return "board/replyUpdateView";
		
	}
	
	//댓글 수정 POST
	@RequestMapping(value="board/replyUpdate", method= RequestMethod.POST)
	public String replyUpadate(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("reply Write");
		
		replyService.updateReply(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
	
		return "redirect:/board/readView";
	}
	
	//댓글 삭제 GET test를위한 추가 작성
	@RequestMapping(value="board/replyDeleteView", method= RequestMethod.GET)
	public String replyDeleteView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception{
		logger.info("reply Write");
		
		model.addAttribute("replyDelete", replyService.selectReply(vo.getRno()));
		model.addAttribute("scri", scri);
		return "board/replyDeleteView";
	}
	
	//댓글 삭제 POST 입니다.
	@RequestMapping(value="board/replyDelete", method= RequestMethod.POST)
	public String replyDelete(ReplyVO vo, SearchCriteria scri,RedirectAttributes rttr) throws Exception{
		logger.info("reply Write");
		
		//주의
		replyService.deleteReply(vo);
		
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page",scri.getPage());
		rttr.addAttribute("perPageNum",scri.getPerPageNum());
		rttr.addAttribute("searchType",scri.getSearchType());
		rttr.addAttribute("keyword",scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	
	

}
