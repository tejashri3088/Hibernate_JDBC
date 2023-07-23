package onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesFromTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, 2);
			System.out.println("teacher = " +teacher);
			System.out.println("courses = " +teacher.getCourses());
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
