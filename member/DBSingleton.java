package jdbc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
	private static Connection con = null;

	private DBSingleton() {}
	
	public static Connection getInstance()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 접속 주소
		String driver = "oracle.jdbc.OracleDriver"; // 오라클 실행 드라이버 위치
		if(con == null)
		{
			try {
				Class.forName(driver);
				System.out.println("드라이버 로드 성공");
				con = DriverManager.getConnection(url, "scott", "tiger");
				System.out.println("DB 접속 성공");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로드 실패" + e.getMessage());
			} catch (SQLException e) {
				System.out.println("DB 접속 실패" + e.getMessage());
			}
		}
		return con;
	}
	
	
}
