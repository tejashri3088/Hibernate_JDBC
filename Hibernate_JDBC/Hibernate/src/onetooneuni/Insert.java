package onetooneuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import onetooneuni.Teacher;
import onetooneuni.TeacherDetails;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("onetooneuni/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			Teacher teacher = new Teacher("Nikeeta", "Sirvi", "nikeetasirvi@gmail.com");
			TeacherDetails teacherDetails = new TeacherDetails("surat", "adventure");

			teacher.setTeacherDetails(teacherDetails);

//			Transaction tx = null;
//			tx = session.beginTransaction();
			session.beginTransaction();
			
			session.save(teacher);

//			tx.commit();
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
