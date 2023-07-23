package onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("onetoonebi/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			TeacherDetails teacherDetails = session.get(TeacherDetails.class, 1);

			System.out.println("teacher details = " + teacherDetails);
			System.out.println("teacher =" + teacherDetails.getTeacher());

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
