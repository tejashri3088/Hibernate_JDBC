package onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Course course =session.get(Course.class,25);
			Review review1 = new Review("excellent");
			Review review2 = new Review("good");
			
			review1.setCourses(course);
			review2.setCourses(course);
			
			session.save(review1);
			session.save(review2);
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
		
	}

}
