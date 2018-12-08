/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Cole
 */
public class Student {

    private int id;
    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
//    public Integer addStudent(String name) {
//        Session session = Hibernate360.getFactory().openSession();
//        Transaction tx = null;
//        Integer studentID = null;
//
//        try {
//            tx = session.beginTransaction();
//            Student stu = new Student(name);
//            studentID = (Integer) session.save(stu);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return studentID;
//    }

}
