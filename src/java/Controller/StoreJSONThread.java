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
import org.json.simple.JSONObject;

/**
 *
 * @author Cole
 */
public class StoreJSONThread implements Runnable {

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

            ses.close();
            List<Person> results = genericPerson;

            String store = "";

            for (int i = 0; i < results.size(); i++) {
                Person objToJ = new Person();
                objToJ.setid(results.get(i).getid());
                objToJ.setFirstName((results.get(i).getFirstName()));
                objToJ.setLastName((results.get(i).getLastName()));
                objToJ.setClassStanding((results.get(i).getClassStanding()));
                objToJ.setBuilding((results.get(i).getBuilding()));
                objToJ.setApartmentNumber((results.get(i).getApartmentNumber()));

                JSONObject stringify = new JSONObject();

                stringify.put("id", objToJ.getid());
                stringify.put("FirstName", objToJ.getFirstName());
                stringify.put("LastName", objToJ.getLastName());
                stringify.put("ClassStanding", objToJ.getClassStanding());
                stringify.put("Building", objToJ.getBuilding());
                stringify.put("ApartmentNumber", objToJ.getApartmentNumber());

                store += stringify.toJSONString();
            }

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
