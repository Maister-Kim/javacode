package abstractTest;

public class Student extends Person{
	private String studentId;
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public void setID(String id) {
		this.studentId = id;	
	}

	@Override
	String getID() {
		return studentId;
	}

	@Override
	public void inputInfo() {
		super.inputInfo();
		System.out.print("학번 입력: ");
		String id = inputData.inputString();
		setID(id);
		
		System.out.print("학급 입력: ");
		String cl = inputData.inputString();
		setClassName(cl);
	}

	@Override
	public String getInfo() {
		String str = super.getInfo() + "\n학번: " + getID() + "\n학급: " + getClassName() + "\n"; 
		return str;
	}

	@Override
	public void printAll() {
		System.out.println(this.getInfo());
	}

}
