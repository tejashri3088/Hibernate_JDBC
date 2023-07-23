package manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("manytomany/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			Student student = session.get(Student.class, 3);
			session.delete(student);
			
			//similar for deleting course
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
