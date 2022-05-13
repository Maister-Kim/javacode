package jdbc.member;

public class MemberVo {

	private String id;
	private String password;
	private String name;
	private String email;
	
	// 기본생성자 안써도 자동 생성 실행 필드 데이터 초기화
	// 매개변수 있는 생성자 있으면 기본 생성자 자동생성 실행 안함
	public MemberVo() {}
	
	public MemberVo(String id, String password, String name, String email) {
		super();
		setId(id);
		setPassword(password);
		setName(name);
		setEmail(email);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	/*@Override
	public String toString() {
		return "MemberVo [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}*/
	
	@Override // 없으면 주소값 출력
	public String toString() {
		String str = "";
		str = String.format("ID: %8s Password: %8s Name: %8s E-mail: %8s", id, password, name, email);
		return str;
	}
	
	
}
