package kim.kim.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kim.kim.service.BoardService;
import kim.kim.vo.BoardVO;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;

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
	public String list(Model model) throws Exception {
		logger.info("list");

		model.addAttribute("list", service.list());

		return "board/list";
	}

	// 게시판 조회
	@RequestMapping(value = "board/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception {
		logger.info("read");
		// 서비스 read boardVO에 있는 bno를 가져온다.
		model.addAttribute("read", service.read(boardVO.getBno()));

		return "board/readView";
	}

	// 게시판 수정뷰
	@RequestMapping(value = "board/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception {
		logger.info("updateView");

		model.addAttribute("update", service.read(boardVO.getBno()));

		return "board/updateView";
	}

	// 게시판 수정
	@RequestMapping(value = "board/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception {
		logger.info("update");

		service.update(boardVO);

		return "redirect:/board/list";
	}

	// 게시판 삭제
	@RequestMapping(value = "board/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception {
		logger.info("delete");

		service.delete(boardVO.getBno());

		return "redirect:/board/list";
	}

}
