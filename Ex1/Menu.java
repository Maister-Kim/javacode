package Ex1;

import java.util.List;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	Dao dao;
	ViewerService vs;
	MemeberVo vo;
	TourVo tvo;
	boolean isLogin = false;
	
	public Menu() {
		dao = new Dao();
//		vo = new MemeberVo();
		vs = new ViewerService();
	}
	
	public void SelectMenu()
	{
		while(true)
		{
			if(isLogin == false) {
				mainMenu();
				int select = sc.nextInt();
				sc.nextLine();
				
				switch(select)
				{
					case 1:
						System.out.println("로그인 화면으로 이동합니다.");
						isLogin = loginMenu();
						break;
					case 2:
						System.out.println("여행지 검색 화면으로 이동합니다.");
						vs.viewAllTourList();
						break;
					case 3:
						System.out.println("회원가입 화면으로 이동합니다.");
						register();
						break;
					case 4:
						System.exit(0);
				}
			}
			else if(isLogin == true)
			{
				memberMenu();
				int select = sc.nextInt();
				sc.nextLine();
				
				switch(select)
				{
					case 1:
						System.out.println("여행지 검색 화면으로 이동합니다.");
						vs.viewAllTourList();
						System.out.println("예약하실려면 투어명을 입력하세요.(0번은 취소)");
						String choice = sc.nextLine();
						if(choice.equals("0"))
						{
							System.out.println("취소하고 돌아갑니다.");
							break;
						}
						else if(choice.length() != 0)
						{
							tvo = vs.viewSelectList(choice);
							System.out.println("예약하시겠습니까?");
							System.out.println("1.yes 2.no");
							int num = Menu.sc.nextInt();
							sc.nextLine();
							switch(num)
							{
							case 1:
								isLogin = dao.reservationService(vo, tvo);
								SelectMenu();
								break;
							case 2:
								System.out.println("취소하고 메인으로 이동합니다.");
								SelectMenu();
								break;
							default:
								System.out.println("잘못 입력");
								break;
							}
						}
						else
						{
							System.out.println("입력사항이 없습니다.");
							break;
						}
						break;
					case 2:
						System.out.print("키워드 검색: ");
						String name = Menu.sc.nextLine();
						if(name.length() != 0)
						{
							tvo = vs.viewSelectList(name);
							System.out.println("예약하시겠습니까?");
							System.out.println("1.yes 2.no");
							int num = Menu.sc.nextInt();
							sc.nextLine();
							switch(num)
							{
							case 1:
								isLogin = dao.reservationService(vo, tvo);
								SelectMenu();
								break;
							case 2:
								System.out.println("취소하고 메인으로 이동합니다.");
								SelectMenu();
								break;
							default:
								System.out.println("잘못 입력");
								break;
							}
						}
						else
						{
							System.out.println("입력사항이 없습니다.");
							break;
						}
						
						break;
					case 3:
						System.out.println("예약 확인/ 취소");
						vs.viewReserveList(vo);
						System.out.println("취소할 투어 이름을 입력하세요.");
						String t_name = Menu.sc.nextLine();
						if(t_name.length() == 0)
						{
							System.out.println("취소할 내용이 없습니다.");
						}else {
							isLogin = dao.cancelReservation(t_name);
						}
						break;
					case 4:
						System.exit(0);
				}
			}
		}
	}
	
	public void mainMenu()
	{
		System.out.println("1.로그인 2.여행지 검색 3.회원가입 4.종료");
	}
	
	public boolean loginMenu()
	{
		vo = new MemeberVo();
		System.out.println("아이디: ");
		String id = sc.nextLine();
		System.out.println("비밀번호: ");
		String psw = sc.nextLine();
		
		vo.setId(id);
		vo.setPassword(psw);
		
		return dao.loginService(vo);
	}
	
	public void memberMenu()
	{
		System.out.println("1.투어 리스트 2.여행지 검색 3.예약확인/취소 4.종료");
	}
	
	public void register()
	{
		String id;

		while(true)
		{
			System.out.println("아이디: ");
			id = sc.nextLine();
			if(dao.checkID(id) == true)
				break;
		}
		System.out.println("비밀번호: ");
		String pwd = sc.nextLine();
		System.out.println("이름: ");
		String name = sc.nextLine();
		System.out.println("주소: ");
		String add = sc.nextLine();
		System.out.println("전화번호: ");
		String pho = sc.nextLine();
		
		vo = new MemeberVo(id, pwd, name, add, pho);
		
		dao.registerService(vo);
	}
	
//	public void reservationMenu()
//	{
//		System.out.println("1.로그인 2.여행지 검색 3.예약확인/취소 4.종료");
//	}
}
