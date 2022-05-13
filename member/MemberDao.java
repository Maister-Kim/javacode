package jdbc.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	//기본 생성자로 DB연결 = > 싱글톤
	public MemberDao() {
		con = DBSingleton.getInstance();
	}
	
	//회원가입
	public int insertData(MemberVo vo)
	{
		int result = 0;
		String sql = "INSERT INTO member VALUES(?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getEmail());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("DB 에러" + e.getMessage());
			
		}finally {
			DBClose.close(ps);
		}
		
		return result;
	}
	
	//회원수정
	public int updateData(MemberVo vo)
	{
		int result = 0;
		String sql = "UPDATE member set password = ?, name = ?, email = ? WHERE id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DB 에러" + e.getMessage());
		} finally {
			DBClose.close(ps);
		}
		
		return result;
	}
	
	//회원 삭제
	public int deleteData(MemberVo vo) 
//	public int deleteData(String id) 
	{
		int result = 0;
		String sql = "DELETE FROM member WHERE id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("DB 에러" + e.getMessage());
			
		}finally {
			DBClose.close(ps);
		}
		
		return result;
	}
	
	//회원검색
	public ArrayList<MemberVo> searchAllData()
	{
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM member";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				MemberVo mv = new MemberVo();
				mv.setId(rs.getString("id"));
				mv.setPassword(rs.getString("password"));
				mv.setName(rs.getString("name"));
				mv.setEmail(rs.getString("email"));
				
				list.add(mv);
			}
		} catch (SQLException e) {
			System.out.println("DB 에러" + e.getMessage());
		}finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		
		return list;
	}
	
	// 회원 이름으로 검색
	public ArrayList<MemberVo> searchForName(String name)
	{
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM member WHERE name like '%'||?||'%'"; // '%'||?||'%' => 동명이인이 있으면 모두 출력"
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next())
			{
				MemberVo mv = new MemberVo();
				mv.setId(rs.getString("id"));
				mv.setPassword(rs.getString("password"));
				mv.setName(rs.getString("name"));
				mv.setEmail(rs.getString("email"));
				
				list.add(mv);
			}
		} catch (SQLException e) {
			System.out.println("DB 에러" + e.getMessage());
		}finally {
			DBClose.close(rs);
			DBClose.close(ps);
		}
		
		return list;
	}
	
	public void close() throws SQLException{
		if(con != null) {
			if(!con.isClosed())
				con.close();
		}
	}
}