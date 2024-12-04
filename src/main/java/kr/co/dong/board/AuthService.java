package kr.co.dong.board;

public interface AuthService {
	
	String getAccessToken(String code);
	
    UserDTO getUserInfo(String accessToken);
    
    

}
