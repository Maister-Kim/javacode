package abstractTest;

public abstract class Person {

	private String name;
	private String address;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	abstract void setID(String id);
	abstract String getID();
	
	public void inputInfo()
	{
		System.out.print("이름 입력: ");
		String name = inputData.inputString();
		setName(name);
		
		System.out.print("주소 입력: ");
		String Address = inputData.inputString();
		setAddress(Address);
	}
	
	public String getInfo()
	{
		String str = "이름: " + getName() + "\n주소: " + getAddress();
		return str;
	}
	
	public void printAll()
	{
		System.out.println(this.getInfo());
	}
	
	
}
