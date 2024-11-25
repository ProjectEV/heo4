package kr.co.dong.board;

import java.util.Map;

public interface ProjectDAO {

	//로그인 처리
	public Map<String, Object> login(Map<String,Object> map);
		
	//회원가입 처리
	public int join(UserDTO userDTO);
	
	//아이디 중복체크 처리
	public int id_check(String user_id);
	
	//리뷰작성 처리
	public int review(BoardsDTO boardsDTO);
	
		


	}




