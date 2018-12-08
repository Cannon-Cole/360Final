

import Model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Person {

    private int id;
    private String FirstName;
    private String LastName;
    private String ClassStanding;
    private String Building;
    private int ApartmentNumber;

    public Person() {

    }

    public Person(String firstName, String lastName, String classStanding, String building, int apartmentNumber) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.ClassStanding = classStanding;
        this.Building = building;
        this.ApartmentNumber = apartmentNumber;
    }
    
    public Integer addPerson(String firstName, String lastName, String classStanding, String building, int apartmentNumber) {
        Session session = Hibernate.getFactory().openSession();
        Transaction tx = null;
        Integer personID = null;

        try {
            tx = session.beginTransaction();
            Person per = new Person(firstName, lastName, classStanding, building, apartmentNumber);
            personID = (Integer) session.save(per);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personID;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getClassStanding() {
        return ClassStanding;
    }

    public void setClassStanding(String ClassStanding) {
        this.ClassStanding = ClassStanding;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String Building) {
        this.Building = Building;
    }

    public int getApartmentNumber() {
        return ApartmentNumber;
    }

    public void setApartmentNumber(int ApartmentNumber) {
        this.ApartmentNumber = ApartmentNumber;
    }
}
