package kr.co.dong.board;

public class NaverUserInfo {
	private String name;
    private String email;

    public NaverUserInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }

	// Getter와 Setter 추가
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
	public String toString() {
		return "NaverUserInfo [name=" + name + ", email=" + email + "]";
	}
    
    
}

