package onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).
				addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Teacher teacher =session.get(Teacher.class,11);
			Course course1 = new Course("python");
			Course course2 = new Course("sql");
			
			course1.setTeacher(teacher);
			course2.setTeacher(teacher);
			
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
