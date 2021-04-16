package kim.kim.dao;

import java.util.List;

import kim.kim.vo.BoardVO;

public interface BoardDAO {
	// 게시글 작성
		public void write(BoardVO boardVO) throws Exception;
		
	// 게시글 목록 조회
		public List<BoardVO> list() throws Exception;
		
	// 게시물 조회
		public BoardVO read(int bno) throws Exception;
		
	// 게시글 수정
		public void update(BoardVO boardVO) throws Exception;
	
	// 게시글 삭제
		public void delete(int bno) throws Exception;
		
}
