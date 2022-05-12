import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        String hql = "From " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseList = session.createQuery(hql).getResultList();
        purchaseList.forEach(purchase -> {
            Transaction transaction = session.beginTransaction();

            String hqlCourseId = "From " + Course.class.getSimpleName() +
                    " Where name = '" + purchase.getCourseName() + "'";
            Course course = (Course) session.createQuery(hqlCourseId).getSingleResult();

            String hqlStudentId = "From " + Student.class.getSimpleName() +
                    " Where name = '" + purchase.getStudentName() + "'";
            Student student = (Student) session.createQuery(hqlStudentId).getSingleResult();

            Query qInsertIntoIgnore = session.createSQLQuery("INSERT IGNORE INTO linkedpurchaselist" +
                    " (course_id, student_id) VALUES (:course_id, :student_id)");
            qInsertIntoIgnore.setParameter("course_id", course.getId());
            qInsertIntoIgnore.setParameter("student_id", student.getId());
            int resulrQuery = qInsertIntoIgnore.executeUpdate();

            transaction.commit();
        });

        sessionFactory.close();

    }
}
