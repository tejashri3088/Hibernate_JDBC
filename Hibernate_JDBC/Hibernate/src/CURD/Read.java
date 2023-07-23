package CURD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Read {

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
			
			//get single row
			Teacher teacher = session.get(Teacher.class, 1);
			System.out.println("teacher id -->" +teacher.getId());
			System.out.println("teacher f_name -->" +teacher.getF_name());
			System.out.println("teacher l_name -->" +teacher.getL_name());
			System.out.println("teacher email -->" +teacher.getEmail());
			
			//get multiple rows
			//List<Teacher> teachers = session.createQuery("from Teacher").list();
			List<Teacher> teachers = session.createQuery("from Teacher where id>1").list();
			for(Teacher t :teachers) {
				System.out.println("teacher id -->" +t.getId());
				System.out.println("teacher f_name -->" +t.getF_name());
				System.out.println("teacher l_name -->" +t.getL_name());
				System.out.println("teacher email -->" +t.getEmail());
			}
			
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
