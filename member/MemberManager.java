package jdbc.member;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberManager {
	MemberDao dao;
	MemberVo vo;
	
	public MemberManager() {
		dao = new MemberDao();
		vo = new MemberVo();
	}

	public void signIn()
	{
		System.out.println("회원정보 입력");
		System.out.print("ID: ");
		vo.setId(Menu.sc.nextLine());
		System.out.print("PASSWORD: ");
		vo.setPassword(Menu.sc.nextLine());
		System.out.print("NAME: ");
		vo.setName(Menu.sc.nextLine());
		System.out.print("E-MAIL: ");
		vo.setEmail(Menu.sc.nextLine());
		
		int res = dao.insertData(vo);
		if(res>0)
			System.out.println("입력성공");
		else
			System.out.println("입력실패");
	}
	
	public void searchAll()
	{
		ArrayList<MemberVo> list = dao.searchAllData();
		
		/*for(MemberVo li : list)
		{
			System.out.println(li.toString());
		}*/
		
		Iterator<MemberVo> it = list.iterator();
		while(it.hasNext())
		{
			MemberVo vo = it.next();
			System.out.println(vo.toString());
		}
	}
	
	public void searchName()
	{
		System.out.print("검색할 이름: ");
		String name = Menu.sc.nextLine();
		
		ArrayList<MemberVo> list = dao.searchForName(name);
		
		if(list.size() == 0)
		{
			System.out.println("입력한 이름 없음");
		}
		
		for(MemberVo li : list)
		{
			System.out.println(li.toString());
		}
		
	}
	
	public void updateInfo()
	{
		System.out.println("변경할 아이디 입력: ");
		System.out.print("ID: ");
		vo.setId(Menu.sc.nextLine());
		System.out.print("PASSWORD: ");
		vo.setPassword(Menu.sc.nextLine());
		System.out.print("NAME: ");
		vo.setName(Menu.sc.nextLine());
		System.out.print("E-MAIL: ");
		vo.setEmail(Menu.sc.nextLine());
		
		int res = dao.updateData(vo);
		if(res>0)
			System.out.println("수정성공");
		else
			System.out.println("수정실패");
	}
	
	public void deleteInfo()
	{
		System.out.print("ID: ");
		vo.setId(Menu.sc.nextLine());
		int res = dao.deleteData(vo);
		if(res>0)
			System.out.println("삭제성공");
		else
			System.out.println("삭제실패");
	}
}
