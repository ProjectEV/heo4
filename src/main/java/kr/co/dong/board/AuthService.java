package kr.co.dong.board;

public interface AuthService {
	
	String getAccessToken(String code);
	
    NaverUserInfo getUserInfo(String accessToken);
    
    

}
