package kr.co.dong.board;

import java.util.List;
import java.util.Map;

public interface ProjectService {
	
	//로그인 처리
	public Map<String, Object> login(Map<String, Object> map);
	
	
	//네이버 로그인 처리
		public int naver_login(NaverUserInfo naveruserinfo);
	
	//회원가입 처리
	public int join(UserDTO userDTO);
	
	//아이디 중복체크 처리
	public int id_check(String user_id);
	
	//아이디 찾기 처리
	public String id_search(Map<String, Object> map);
	
	//비밀번호 찾기 처리
	
	public String pwd_search(String user_id);
	
	//비밀번호 변경 처리
	public int pwd_change(String user_id, String user_password);
	
	
	//리뷰작성 처리
	public int review(BoardsDTO boardsDTO);
	
	//제품 상세페이지
	public ProductDTO productDetail(String product_id);
	
	//다중 이미지 조회
	public List<String> fileSelect(String product_id);
	
	//리뷰 다중처리
	public List<BoardsDTO> review_list(String product_id);
	


	
		
}
