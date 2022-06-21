package Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Connection con;
	
	private Singleton() {}
	
	public static Connection getInstance()
	{
		try {
			String driver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB 접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
