package friendListExam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Friend implements Serializable{
	List<Friend> list = new ArrayList<>();
	
	protected String name;
	protected String tel;
	protected String address;
	
//	transient Scanner sc = new Scanner(System.in); transient => 직렬화에 추가 안되게 선언
	
	public Friend() {
		super();
	}
	
	public Friend(String name, String tel, String address) {
		setName(name);
		setTel(tel);
		setAddress(address);
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void inputInfo()
	{
		System.out.println("이름입력: ");
		String name = InputM.StringData();
		System.out.println("전화입력: ");
		String add = InputM.StringData();
		System.out.println("주소입력: ");
		String tel = InputM.StringData();
		list.add(new Friend(name, tel, add));
	}

	public void Display()
	{
		for(int i=0;i<list.size();i++)
		{
			Friend fr1 = list.get(i);
			System.out.println(fr1.name + fr1.tel + fr1.address);
		}
	}

	@Override
	public String toString() {
		return "Friend [list=" + list + ", name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}
}
