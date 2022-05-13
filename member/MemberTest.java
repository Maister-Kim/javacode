package jdbc.member;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class MemberTest {
	
	public void printString(String id, String password, String name)
	{
		System.out.println("MemberVo [id=" + id + ", password=" + password + ", name=" + name + "]");
	}
	public static void main(String[] args) throws SQLException{
		/*MemberTest mt = new MemberTest();
		MemberVo vo = new MemberVo();
		MemberVo vo2 = new MemberVo("korea", "krea", "korea", "kora");
		
		System.out.println(vo.toString());
		System.out.println(vo2.toString());
		
		vo2.setPassword("korea");
		vo2.setEmail("korea@korea.com");
		
		System.out.println(vo2);
		
		System.out.println("MemberVo [id=" + vo2.getId() + ", password=" + vo2.getPassword() + ", name=" + vo2.getName() + "]");
		
		String id = vo2.getId();
		String password = vo2.getPassword();
		String name = vo2.getName();
		mt.printString(id, password, name);
		*/
		MemberManager mm = new MemberManager();
		int menu = 0;
		
		while(true) {
			do {
				try {
					Menu.mainMen();
					menu = Menu.sc.nextInt();
					Menu.sc.nextLine(); // 숫자는 엔터값이 없으므로 개행문자 처리를 위해 입력
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자만 입력" + e.toString());
					Menu.sc.nextLine(); // 여기도 개행문자 처리
				}
			}while(true);
			
	
			switch(menu) {
				case 1:
					System.out.println("회원가입");
					mm.signIn();
					break;
			case 2:
				System.out.println("전체검색");
				mm.searchAll();
				break;
			case 3:
					System.out.println("이름으로 검색");
					mm.searchName();
					break;
			case 4:
				System.out.println("정보수정");
				mm.updateInfo();
				break;
			case 5:
				System.out.println("회원삭제");
				mm.deleteInfo();
				break;
			case 6:
				System.out.println("종료");
				mm.dao.close();
				System.exit(0);
			default:
				System.out.println("잘못입력");
				break;
			}
		}
	}
}
