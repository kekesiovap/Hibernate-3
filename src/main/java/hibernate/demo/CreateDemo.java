package hibernate.demo;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] argz) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            /*
            Instructor tempInstructor = new Instructor("Jaina", "Proudmore", "jain@azeroth.luv");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/Jaina", "Kirin Tor");
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            */

            Instructor tempInstructor = new Instructor("Nissa", "Revane", "nisska@mail.sk");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/Nissa", "Nature");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
