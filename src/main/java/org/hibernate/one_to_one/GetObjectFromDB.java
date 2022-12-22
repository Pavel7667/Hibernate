package org.hibernate.one_to_one;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.one_to_one.entity.Detail;
import org.hibernate.one_to_one.entity.Employee;

import java.util.List;


/**
 * Demo class for work with DB
 * <p>SessionFactory which using "hibernate.cfg.xml" file to connect to DB
 * and create Object using Reflection
 * <p>Session use HQL command for Insert Object into DB
 */
public class GetObjectFromDB {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // file to connect to DB
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Jo", "Li", "IT", 1);
            Detail det = new Detail("City", "+", "gmail");
            emp.setEmpDetail(det);

            session.beginTransaction();

            session.save(emp);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

