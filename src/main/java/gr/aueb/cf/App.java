package gr.aueb.cf;

import gr.aueb.cf.model.Course;
import gr.aueb.cf.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev6PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Object[]> andreasCourses = em.createQuery("SELECT t, c FROM Teacher t JOIN t.courses c WHERE c.title LIKE :course", Object[].class)
                .setParameter("course", "Py%").getResultList();

        for (Object[] arr : andreasCourses) {
            for (Object item : arr) {
                System.out.println(item);
            }
            System.out.println();
        }

//        List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
//        teachers.forEach(System.out::println);

//        Teacher teacher = em.createQuery("SELECT t FROM Teacher t WHERE t.firstname = :firstname", Teacher.class)
//                .setParameter("firstname", "Andreas")
//                .getSingleResult();

//        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE t.firstname = :firstname", Teacher.class);
//        query.setParameter("firstname", "Andreas");
//        Teacher teacher = query.getSingleResult();
//
//        System.out.println(teacher);


//        Teacher andreas = em.find(Teacher.class, 2L);
//        em.remove(andreas);

//        Teacher andreas = new Teacher(null, "Andreas", "Androutsos", null);
//        Course python = new Course(null, "Python", null);
//        Course csharp = new Course(null, "C Sharp", null);
//        andreas.addCourse(python);
//        andreas.addCourse(csharp);
//
//        em.persist(andreas);
//        em.persist(python);
//        em.persist(csharp);

//        Teacher alice = em.find(Teacher.class, 1L);
//        alice.setLastname("Wonderland");
//        em.merge(alice);

//        Teacher alice = new Teacher(null, "Alice", "W.", null);
//
//        Course java = new Course(null, "Java", null);
//        alice.addCourse(java);
//
//        em.persist(alice);
//        em.persist(java);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
