package kr.co.dong.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAOimpl implements ProjectDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace ="kr.co.dong.resources.ProjectMapper";

	//로그인 처리
	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".login",map);
		}
	
	//네이버 로그인 처리
	@Override
	public int naver_login(NaverUserInfo naveruserinfo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".naver_login",naveruserinfo);
	}

	//회원가입 처리
	@Override
	public int join(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".join",userDTO);
	}
	// 리뷰 작성 처리
	@Override
	public int review(BoardsDTO boardsDTO) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert(nameSpace+".review",boardsDTO);
	}
	//아이디 중복체크 처리
	@Override
	public int id_check(String user_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".id_check",user_id);
	}
	
	@Override
	public String id_search(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".id_search", map);
	}

	@Override
	public ProductDTO productDetail(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".productDetail", product_id);
	}

	@Override
	public List<String> fileSelect(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".fileSelect", product_id);
	}

	@Override
	public List<BoardsDTO> review_list(String product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace+".review_list", product_id);
	}

	
	
	

}
