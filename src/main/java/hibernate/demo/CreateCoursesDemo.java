package hibernate.demo;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor tempinstructor = session.get(Instructor.class, 1);
            /*
            Course tempCourse1 = new Course("Magic");
            Course tempCourse2 = new Course("Elven language");

            Course tempCourse1 = new Course("Fencing");
            Course tempCourse2 = new Course("Dragon flight");
            */

            Course tempCourse3 = new Course("Elven language");

            /*
            tempinstructor.add(tempCourse1);
            tempinstructor.add(tempCourse2);
             */

            tempinstructor.add(tempCourse3);

            /*
            session.save(tempCourse1);
            session.save(tempCourse2);
            */

            session.save(tempCourse3);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}





