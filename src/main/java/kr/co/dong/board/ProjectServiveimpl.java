package kr.co.dong.board;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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

}
