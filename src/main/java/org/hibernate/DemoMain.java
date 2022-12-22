package org.hibernate;

import org.hibernate.cfg.Configuration;

/**
 * Demo class for work with DB
 * <p>SessionFactory which using "hibernate.cfg.xml" file to connect to DB
 * and create Object using Reflection
 * <p>Session use HQL command for Insert Object into DB
 *
 */
public class DemoMain {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // file to connect to DB
                .addAnnotatedClass(EntityStaff.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            EntityStaff one = new EntityStaff("Roma", "Li", "IT", 500);

            session.beginTransaction();
            session.save(one);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
