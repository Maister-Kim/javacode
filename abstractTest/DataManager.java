package abstractTest;

public class DataManager {
	Person[] p = new Person[10];
	private int count;
	
	public Person[] getP() {
		return p;
	}
	public void setP(Person[] p) {
		this.p = p;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	} 
	
	void register()
	{
		int input = 0;
		boolean bool = false;
		outer:
			
		while(true)
		{
		
			do {
				try{
					Menu.subMenu();
					input = inputData.inputInt();
					inputData.inputString();
					bool = false;
				}catch(Exception e){
//					inputData.inputString();
					System.out.println("잘못입력");
					bool = true;
				}
			}while(bool);
			
			switch(input)
			{
				case 1:
					Student st = new Student();
					System.out.println("학생등록");
					st.inputInfo();
					addPerson(st);
					break;
				case 2:
					System.out.println("교사등록");
					Teacher tc = new Teacher();
					tc.inputInfo();
					addPerson(tc);
					break;
				case 3:
					System.out.println("직원등록");
					break;
				case 4:
					System.out.println("상위 메뉴로");
					break outer;
				default:
					System.out.println("잘못입력");
			}
		}	
	}
	
	void addPerson(Person person)
	{
		if(count < p.length)
		{
			p[count++] =  person;
			System.out.println("저장인원 " + count + "/" + p.length + "명");
		}
		else
			System.out.println("배열인원초과");
	}
	
	void search()
	{
		inputData.inputString();
		System.out.println("검색할 이름 입력: ");
		String str = inputData.inputString();
		for(int i=0;i<count;i++)
		{
			String pName = p[i].getName();
			if(str.equals(pName))
			{
				System.out.println("검색한 사람 찾음");
				p[i].printAll();
				return;
			}
		}
		System.out.println("검색할 사람 없음");
	}
	
	void delete()
	{
		inputData.inputString();
		System.out.println("삭제할 이름 입력: ");
		String str = inputData.inputString();
		for(int i=0;i<count;i++)
		{
			String pName = p[i].getName();
			for(int j = i;j<count;j++)
			{
				if(str.equals(pName))
				{
					System.out.println("삭제할 사람 찾음");
					p[j].printAll();
//					p[j] = null;
					p[j] = p[j+1];
					System.out.println("삭제완료");
					count--;
					return;
				}
			}
		}
		System.out.println("삭제할 사람 없음");
	}
	
	void print()
	{
		String studentStr = "\n-------- 학 생 ---------\n";
		String teacherStr = "\n-------- 교 사 ---------\n";
		String staffStr = "\n-------- 직 원 ---------\n";
		int scount=0,tcount=0,sfcount=0;
		for(int i=0;i<count;i++)
		{
			if(p[i] instanceof Student)
			{
				studentStr += p[i].getInfo();
				scount++;
			}
			else if(p[i] instanceof Teacher)
			{
				teacherStr += p[i].getInfo();
				tcount++;
			}
//			else if(p[i] instanceof Staff)
//			{
//				staffStr += p[i].getInfo();
//			}
		}
//		System.out.println(studentStr + teacherStr + staffStr);
		if(scount != 0)
			System.out.println(studentStr);
		if(tcount != 0)
			System.out.println(teacherStr);
		if(sfcount != 0)
			System.out.println(staffStr);
	}
}
