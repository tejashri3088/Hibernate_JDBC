package onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetReviewFromCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Course course = session.get(Course.class, 6);
			System.out.println("Course = " +course);
			System.out.println("Reviews = " +course.getReviews());
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
