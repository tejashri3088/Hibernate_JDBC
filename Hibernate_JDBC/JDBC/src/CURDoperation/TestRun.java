package CURDoperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestRun {

	public void display(Statement stmt) throws Exception {
		String str = "select id,username,coursename,coursefee,courseduration from coursestats";
		ResultSet rs = stmt.executeQuery(str);
		while(rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String coursename = rs.getString("coursename");
			int coursefee = rs.getInt("coursefee");
			int courseduration = rs.getInt("courseduration");

			System.out.println("id= " +id);
			System.out.println("username= " +username);
			System.out.println("coursename= " +coursename);
			System.out.println("coursefee= " +coursefee);
			System.out.println("courseduration= " +courseduration);
		}
		rs.close();
	}

	public void insert(Connection conn) throws Exception {
		String str = "insert into coursestats (id,username,coursename,coursefee,courseduration) values(?,?,?,?,?)";
		PreparedStatement psts = conn.prepareStatement(str);
		psts.setInt(1, 10);
		psts.setString(2, "niki");
		psts.setString(3, "testing");
		psts.setInt(4, 40000);
		psts.setInt(5, 30);
		System.out.println("status = " +psts.executeUpdate());
		psts.close();
	}

	public void update(Statement stmt) throws Exception {
		String str = "update coursestats set coursefee = 1000 where id = 10";
		System.out.println("status = " +stmt.executeUpdate(str));
	}
	
	public void delete(Statement stmt) throws Exception {
		String str = "delete from coursestats where id=10";
		System.out.println("status = " +stmt.executeUpdate(str));
	}
}
