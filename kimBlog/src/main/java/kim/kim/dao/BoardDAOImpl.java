package kim.kim.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kim.kim.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
		
	}

	@Override
	public List<BoardVO> list() throws Exception {
		
		//boardMapper.xml에서 mapper의 namespace가 boardMapper이고 그중에 id가 list인것을 가져와서 반환해라 
		return sqlSession.selectList("boardMapper.list");
	}
	
	

}
