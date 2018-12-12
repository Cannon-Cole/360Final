/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Hibernate;
import Model.PassAround;
import Model.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Cole
 */
public class DisplayAllThread implements Runnable {

    @Override
    public void run() {
        try {
            PassAround.message = "thread";
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            SessionFactory fac = factory;
            Session ses = fac.openSession();

            String hql = "SELECT p FROM Person p";
            org.hibernate.query.Query<Person> query = ses.createQuery(hql);

            List genericPerson = query.list();

            List<Person> results = genericPerson;

            String table = "<table>";

            for (int i = 0; i < results.size(); i++) {
                table += "<tr>";
                table += "<td>";
                table += Integer.toString(results.get(i).getid());
                table += "</td>";
                table += "<td>";
                table += results.get(i).getFirstName();
                table += "</td>";
                table += "<td>";
                table += results.get(i).getLastName();
                table += "</td>";
                table += "<td>";
                table += results.get(i).getClassStanding();
                table += "</td>";
                table += "<td>";
                table += results.get(i).getBuilding();
                table += "</td>";
                table += "<td>";
                table += Integer.toString(results.get(i).getApartmentNumber());
                table += "</td>";
                table += "</tr>";
            }

            table += "</table>";

            PassAround.table = table;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        try {
            PassAround.latchDisplay.countDown();
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
