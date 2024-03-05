package UTIL;

import java.util.logging.Level;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory SFACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        try {
            return new Configuration().configure().buildSessionFactory();
        }catch(Throwable sfe) {
            System.err.println("SessionFactopry creation failed. " + sfe);
        }
        return null;
    }

    public static void shutdownSessionFactory() {
        getSessionFactory().close();
    }

    public static SessionFactory getSessionFactory() {
        return SFACTORY;
    }
}