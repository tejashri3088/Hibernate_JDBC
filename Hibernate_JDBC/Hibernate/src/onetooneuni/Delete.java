package onetooneuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("onetooneuni/hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, 2);

			if (teacher != null) {
				System.out.println("Deleting.....");

				// it will also delete TeacherDetails data as we have provided CascadeType.ALL
				session.delete(teacher);

				session.getTransaction().commit();
			}
			
		} finally {
			factory.close();
		}

	}

}
