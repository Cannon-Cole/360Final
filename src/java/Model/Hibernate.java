package Model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static SessionFactory factory;

    public Hibernate() {
        try {
            this.factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        Hibernate.factory = factory;
    }
}
