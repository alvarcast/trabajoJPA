package org.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSession {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;

    private HibernateSession() {} // Evitar instanciación

    public static synchronized Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
