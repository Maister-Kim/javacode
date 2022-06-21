package Ex1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	PreparedStatement ps;
	ResultSet rs;
	Statement st;
	
	public static void close(PreparedStatement ps)
	{
		try {
			if(!ps.isClosed())
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs)
	{
		try {
			if(!rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement st)
	{
		try {
			if(!st.isClosed())
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
