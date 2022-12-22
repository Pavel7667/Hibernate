//package org.hibernate;
//
//import org.hibernate.cfg.Configuration;
//
//import java.util.List;
//
///**
// * Demo class for work with DB
// * <p>SessionFactory which using "hibernate.cfg.xml" file to connect to DB
// * and create Object using Reflection
// * <p>Session use HQL command for Insert Object into DB
// */
//public class GetObjectFromDB {
//    public static void main(String[] args) {
//
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml") // file to connect to DB
//                .addAnnotatedClass(EntityStaff.class)
//                .buildSessionFactory();
//
//        try {
//            Session session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            List<EntityStaff> staffList = session
//                    .createQuery("from EntityStaff where name ='Roma'")
//                    .getResultList();
//
//            for (EntityStaff e : staffList){
//                e.setSalary(1500);
//                session.delete(e);
//                System.out.println(e);
//            }
//
//            session.createQuery("delete EntityStaff where name='Tom'").executeUpdate();
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//    }
//}
//
