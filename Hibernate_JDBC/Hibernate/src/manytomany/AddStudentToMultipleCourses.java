package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddStudentToMultipleCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("manytomany/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			Student student = session.get(Student.class, 3);
			Course course1 = session.get(Course.class, 2);
			Course course2 = session.get(Course.class, 3);
			
			List<Course> list = new ArrayList<Course>();
			list.add(course1);
			list.add(course2);
			
			student.setCourses(list);
			
			session.save(student);
			
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
