package CURDoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		TestRun tr = new TestRun();

		Connection conn = null;
		Statement stmt = null;
		int option;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", "root", "");
			stmt = conn.createStatement();
			do {
				System.out.println("courses database-------------");
				System.out.println("1:display");
				System.out.println("2:insert");
				System.out.println("3:modify");
				System.out.println("4:delete");
				option = input.nextInt();
				switch (option) {
					case 1:
						tr.display(stmt);
						break;
					case 2:
						tr.insert(conn);
						break;
					case 3:
						tr.update(stmt);
						break;
					case 4:
						tr.delete(stmt);
						break;
				}
			} while (option > 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(input!=null) {
				input.close();
			}
		}
		
	}

}
