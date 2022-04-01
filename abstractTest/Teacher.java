package abstractTest;

public class Teacher extends Person {
	String teacherId;
	String subject;
	
	@Override
	void setID(String id) {
		this.teacherId = id;
	}

	@Override
	String getID() {
		return teacherId;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void inputInfo() {
		super.inputInfo();
		System.out.print("교번 입력: ");
		String id = inputData.inputString();
		setID(id);
		
		System.out.print("과목 입력: ");
		String sb = inputData.inputString();
		setSubject(sb);
	}


	@Override
	public String getInfo() {
		String str = super.getInfo() + "\n교번: " + getID() +  "\n과목: " + getSubject() + "\n";
		return str;
	}

	@Override
	public void printAll() {
		System.out.println(this.getInfo());
	}

}
