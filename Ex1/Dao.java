package Ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.text.SimpleDateFormat;

public class Dao {
	static int set_number = 10000;
	int order_number = set_number;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Menu menu;
	int res;

	public Dao() {
		con = Singleton.getInstance();
	}

//	public List<MemeberVo> memberlistAll() {
//		List<MemeberVo> list = new Vector<MemeberVo>();
//		try {
//			String sql = "select * from member";
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				MemeberVo vo = new MemeberVo();
//				vo.setId(rs.getString("id"));
//				vo.setPassword(rs.getString("password"));
//				vo.setName(rs.getNString("name"));
//				vo.setAddress(rs.getString("address"));
//				vo.setPhone(rs.getString("phone"));
//				list.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBClose.close(rs);
//			DBClose.close(ps);
//		}
//		return list;
//	}

	// 모든 투어 리스트 표시
	public List<TourVo> allTourlist() {
		List<TourVo> list = new Vector<TourVo>();
		try {
			String sql = "select * from d_tour";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TourVo tvo = new TourVo();
				tvo.setTourName(rs.getString("tourName"));
				tvo.setDeparture(rs.getString("departure"));
				tvo.setArrival(rs.getString("arrival"));
				tvo.setDeptDate(rs.getDate("deptDate"));
				tvo.setArrivDate(rs.getDate("arrivDate"));
				list.add(tvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		System.out.println("dao: "+list.size());
		return list;
	}

	// 투어 검색
	public List<TourVo> findTour(String name) {
		List<TourVo> list = new Vector<TourVo>();
		try {
			String sql = "SELECT * FROM d_tour WHERE tourName LIKE '%'||?||'%'";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				TourVo tvo = new TourVo();
				tvo.setTourName(rs.getString("tourName"));
				tvo.setDeparture(rs.getString("departure"));
				tvo.setArrival(rs.getString("arrival"));
				tvo.setDeptDate(rs.getDate("deptDate"));
				tvo.setArrivDate(rs.getDate("arrivDate"));
				list.add(tvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		return list;
	}

	// 로그인 아이디 검색
	public boolean loginService(MemeberVo vo) {
		boolean bool = false;
		menu = new Menu();
		try {
			String sql = "SELECT * FROM member WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			rs = ps.executeQuery();
			if (rs.next() == true) {
				if (vo.getPassword().equals(rs.getString("password"))) {
					System.out.println("로그인 했습니다.");
					bool = true;
				} else {
					System.out.println("아이디나 비밀번호가 틀립니다.");
				}
			} else {
				System.out.println("아이디가 없습니다.");
				System.out.println("회원가입창으로 이동하시겠습니까?");
				System.out.println("1.yes 2.no");
				int num = Menu.sc.nextInt();
				Menu.sc.nextLine();
				switch (num) {
				case 1:
					System.out.println("회원가입 메뉴로 이동합니다.");
					menu.register();
					break;
				case 2:
					System.out.println("메인메뉴로 이동합니다.");
					menu.SelectMenu();
					break;
				default:
					System.out.println("다시입력");
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		return bool;
	}

	// 모든 투어 리스트 표시
	public void registerService(MemeberVo vo) {
		try {
			String sql = "insert into member values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			ps.setString(5, vo.getPhone());
			System.out.println("위 자료로 회원 가입 하시겠습니까?");
			System.out.println("1.yes 2.no");
			int num = Menu.sc.nextInt();
			if (num == 1)
				res = ps.executeUpdate();
			else
				return;

			if (res == 1) {
				System.out.println("회원가입 성공");
			}
		} catch (SQLException e) {
			System.out.println("회원가입 실패");
		} finally {
			DBClose.close(ps);
		}
	}

	// 아이디 존재유무 검사
	public boolean checkID(String id) {
		boolean bool = false;
		try {
			String sql = "SELECT * FROM member WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next() == true) {
				System.out.println("이미 있는 아이디 입니다.");
			}
			else {
				System.out.println("사용할수 있는 아이디 입니다.");
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		return bool;
	}

	// 예약
	public boolean reservationService(MemeberVo vo, TourVo tvo)
	{
		++order_number;
		Date now = new Date();
		SimpleDateFormat fomatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String now_time = fomatter.format(now);
		String order_id = now_time + String.valueOf(order_number);
		
		try {
			String sql = "insert into d_reservation values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, order_id);
			ps.setString(2, vo.getId());
			ps.setString(3, tvo.getTourName());
			ps.executeUpdate();
			System.out.println("예약이 완료되었습니다.");
			System.out.println("메인 화면으로 이동합니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		return true;
	}
	
	// 예약 리스트
	public List<ReserveVo> reservationList(MemeberVo vo)
	{
		int count = 1;
		List<ReserveVo> list = new Vector<ReserveVo>();
		try {
			String sql = "select * from d_reservation where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				ReserveVo rvo = new ReserveVo();
				rvo.setReserveNumber(rs.getString("reserveNumber"));
				rvo.setTourname(rs.getString("tourname"));
				list.add(rvo);
				count++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		
		return list;
	}
	
	// 예약 취소
	public boolean cancelReservation(String tourname)
	{
		try {
			String sql = "delete from d_reservation where tourname LIKE '%'||?||'%'";
			ps = con.prepareStatement(sql);
			ps.setString(1, tourname);
			int num = ps.executeUpdate();
			if(num==1)
				System.out.println("삭제 완료");
			else
				System.out.println("삭제 실패");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBClose.close(ps);
		}
		return true;
	}
//	
//	import java.util.Date;
//	import java.text.SimpleDateFormat;
//	Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
//	// 년월일시분초 14자리 포멧
//	SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss"); 
//	System.out.println(fourteen_format.format(date_now)); // 14자리 포멧으로 출력한다
	
//	
//	  public static void main(String[] args) {
//		  MemberDao dao = new MemberDao();
//		  dao.reservationService(null, null);
//	  }
//	  List<MemeberVo> list = dao.listAll(); System.out.println(list.size());
//	  for(MemeberVo vo : list) { System.out.println(vo); }
//	  
//	  
//	  List<TourVo> tlist = dao.allTourlist(); for(TourVo tvo : tlist) {
//	  System.out.println(tvo); }
//	  
	  
//	  List<TourVo> tlist = dao.findTour("제주"); for(TourVo tvo : tlist) {
//	  System.out.println(tvo); } 
//	  }
	
}
