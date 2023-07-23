import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Savepoint;

public class SavePoint {
	
	public static void main(String[] args) throws Exception {
		
		Savepoint sv = null;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Courses","root" ,"");
		
		try {
			
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			sv = conn.setSavepoint("savepoint1");
			System.out.println("savepoint1");
			
			String str = "insert into coursestats(id,username,coursename,coursefee,courseduration) values(10,'niki','dgf',20000,30)";
			stmt.executeUpdate(str);
			
			sv = conn.setSavepoint("savepoint2");
			System.out.println("savepoint2");
			
			str = "insert into coursestats(id,username,coursename,coursefee,courseduration) values(11,'nikiii','dgfffff',10000,40)";
			stmt.executeUpdate(str);
			
			sv = conn.setSavepoint("savepoint3");
			System.out.println("savepoint3");
			
			str = "inserted into coursestats(id,username,coursename,coursefee,courseduration) values(12,'nikiii','dgfffff',10000,40)";
			stmt.executeUpdate(str);
			
			//conn.rollback(sv);
			
			conn.commit();
		} catch(Exception e) {
			System.out.println("Roll back");
			conn.rollback(sv);
			//e.printStackTrace();
		}
		
	}
}
