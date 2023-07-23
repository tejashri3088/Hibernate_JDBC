package onetomanybi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			// for uni direction
			//Review reviews = session.get(Review.class, 9);
			//session.delete(reviews);

			
			
			// for bi direction
			Course courses = session.get(Course.class, 6);

			// without cascade effect only reviews details will be deleted not the courses linked to it
			List<Review> list = courses.getReviews();
			for(Review review: list) {
				session.delete(review);
			}

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
