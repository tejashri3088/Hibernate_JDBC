package onetomanybi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			// for uni direction
			Course courses = session.get(Course.class, 12);
			session.delete(courses);
			
			
			
			// for bi direction
			Teacher teacher = session.get(Teacher.class, 3);
			
			// without cascade effect only courses details will be deleted not teacher linked to it
			List<Course> list = teacher.getCourses();
			for(Course course: list) {
				session.delete(course);
			}
			
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
		
	}

}
