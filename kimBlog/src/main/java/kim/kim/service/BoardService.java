package kim.kim.service;



import java.util.List;

import kim.kim.vo.BoardVO;
import kim.kim.vo.Criteria;
import kim.kim.vo.SearchCriteria;

public interface BoardService {
	//게시글 작성
	public void write(BoardVO boardVO) throws Exception;
	
	//게시글 목록 조회
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	//게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception;
	
	//게시글 조회
	public BoardVO read(int bno) throws Exception;
	
	//게시글 수정
	public void update(BoardVO boardVO) throws Exception;
	
	//게시글 삭제.
	public void delete(int bno) throws Exception;
	

	
	
}
