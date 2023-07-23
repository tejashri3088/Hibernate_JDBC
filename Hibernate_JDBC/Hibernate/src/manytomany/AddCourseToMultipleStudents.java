package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseToMultipleStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("manytomany/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			Course course = session.get(Course.class, 1);
			
			Student student1 = session.get(Student.class, 3);
			Student student2 = session.get(Student.class, 1);
			
			List<Student> list = new ArrayList<Student>();
			list.add(student1);
			list.add(student2);
			
			course.setStudents(list);
			
			session.save(course);
			
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
