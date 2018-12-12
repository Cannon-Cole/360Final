/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Hibernate;
import Model.PassAround;
import Model.Person;
import Student;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Cole
 */
public class AddPersonThread implements Runnable {

    @Override
    public void run() {
        try {
            PassAround.message = "thread";
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            SessionFactory fac = factory;
            Session ses = fac.openSession();
            Transaction tx = null;
            Integer studentID = null;

            try {
                tx = ses.beginTransaction();
                Person per = new Person(name);
                studentID = (Integer) ses.save(per);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                ses.close();
            }
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        try {
            PassAround.latchAdd.countDown();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
