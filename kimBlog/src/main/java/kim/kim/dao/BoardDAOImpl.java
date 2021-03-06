package kim.kim.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kim.kim.vo.BoardVO;
import kim.kim.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	
	//게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
		
	}

	//게시판 목록 조회
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		
		//boardMapper.xml에서 mapper의 namespace가 boardMapper이고 그중에 id가 list인것을 가져와서 반환해라 
		return sqlSession.selectList("boardMapper.listPage", scri);
	}
	
	//게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		
		return sqlSession.selectOne("boardMapper.listCount",scri);
	}

	
	//게시물 조회
	@Override
	public BoardVO read(int bno) throws Exception {
		
		// 한 가지 를 선택해 boardMapper에 read id 를 가져온다 
		return sqlSession.selectOne("boardMapper.read",bno);
	}

	//게시글 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.update",boardVO);
		
	}

	//게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.delete",bno);
		
	}

	//조회수
	@Override
	public void boardHit(int bno) throws Exception {
		sqlSession.update("boardMapper.boardHit",bno);
		
	}

	
	

}
