package onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertTeacherAndTeacherDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("onetomanybi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).
				addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Teacher teacher = new Teacher("Manoj","Sirvi","manoj@gmail.com");
			TeacherDetails teacherDetails = new TeacherDetails("bangalore","photography");
			teacher.setTeacherDetails(teacherDetails);
			
			session.save(teacher);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
