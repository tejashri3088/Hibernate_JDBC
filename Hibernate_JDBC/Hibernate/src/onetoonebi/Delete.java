package onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("onetoonebi/hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();

			TeacherDetails teacherDetails = session.get(TeacherDetails.class, 2);
			
			if(teacherDetails!=null) {
				System.out.println("Deleting.....");
				
				//it will also delete Teacher data associated with it as we have provided CascadeType.ALL
				session.delete(teacherDetails);
			}
			
			session.getTransaction().commit();

		} catch(Exception e) {
			System.out.println(e);
		} 
		finally {
			factory.close();
		}
	}

}
