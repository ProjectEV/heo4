package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProjectServiveimpl implements ProjectService {
	
	@Inject
	ProjectDAO projectDAO;

	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return projectDAO.login(map);
	}
	
	@Override
	public int naver_login(NaverUserInfo naveruserinfo) {
		// TODO Auto-generated method stub
		return projectDAO.naver_login(naveruserinfo);
	}
	
	

	@Override
	public int join(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return projectDAO.join(userDTO);
	}

	@Override
	public int review(BoardsDTO boardsDTO) {
		// TODO Auto-generated method stub
		return projectDAO.review(boardsDTO);
	}

	@Override
	public int id_check(String user_id) {
		// TODO Auto-generated method stub
		return projectDAO.id_check(user_id);
	}
	
	@Override
	public 	String id_search(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return projectDAO.id_search(map);
	}
	
	@Override
	public String pwd_search(String user_id) {
		// TODO Auto-generated method stub
		return projectDAO.pwd_search(user_id);
	}
	
	@Override
	public int pwd_change(String user_id, String user_password) {
		// TODO Auto-generated method stub
		return projectDAO.pwd_change(user_id, user_password);
	}
	
	
	
	

	@Override
	public ProductDTO productDetail(String product_id) {
		// TODO Auto-generated method stub
		return projectDAO.productDetail(product_id);
	}

	@Override
	public List<String> fileSelect(String product_id) {
		// TODO Auto-generated method stub
		return projectDAO.fileSelect(product_id);
	}

	@Override
	public List<BoardsDTO> review_list(String product_id) {
		// TODO Auto-generated method stub
		return projectDAO.review_list(product_id);
	}

	

	


	
	

}
