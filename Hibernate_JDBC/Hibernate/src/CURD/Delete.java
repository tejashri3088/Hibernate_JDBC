package CURD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("connecting to databse");
		SessionFactory factory = null;
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("Connection created");
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
			Teacher teacher = session.get(Teacher.class, 10);
			System.out.println("deleting...");
			session.delete(teacher);
			
			session.createQuery("delete from Teacher where id=3").executeUpdate();
			tx.commit();
			
		} catch(Exception e) {
			System.out.println("error ");
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
