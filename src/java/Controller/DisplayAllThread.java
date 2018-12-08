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
import org.hibernate.Query;

/**
 *
 * @author Cole
 */
public class DisplayAllThread implements Runnable {

    @Override
    public void run() {
        PassAround.message = "in thread";
        String hql = "SELECT * FROM Person";
        Query query = Hibernate.getFactory().openSession().createQuery(hql);
        List<Person> results = query.list();
        String table = "<table>";

        for (int i = 0; i < results.size(); i++) {
            table += "<tr>";
            table += "<th>";
            table += Integer.toString(results.get(i).getid());
            table += results.get(i).getFirstName();
            table += results.get(i).getLastName();
            table += results.get(i).getClassStanding();
            table += results.get(i).getBuilding();
            table += results.get(i).getApartmentNumber();
            table += "</th>";
            table += "</tr>";
        }

        table += "</table>";

        PassAround.table = table;
    }
}