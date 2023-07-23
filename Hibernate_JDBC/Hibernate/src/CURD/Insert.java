package CURD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("connecting to database");
		SessionFactory factory = null;
		factory = new Configuration().configure("CURD/hibernate.cfg.xml").buildSessionFactory();
		System.out.println("connection created");

		Teacher t1 = new Teacher("Sirisha","Jindel","sirisha@gl.com");
		Teacher t2 = new Teacher("Sheetu","Kapoor","sheetu@gl.com");
		Teacher t3 = new Teacher("Ria","Dhopte","ria@gmail.com");
		Teacher t4 = new Teacher("Jenny","Joe","jenny@gmail.com");

		Session session = null;
		Transaction tx = null;
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(t4);
			tx.commit();
		} catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
