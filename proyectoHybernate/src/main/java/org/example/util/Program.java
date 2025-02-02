package org.example.util;

public class Program {
    public static void flux() {
        Runtime.getRuntime().addShutdownHook(new Thread(HibernateSession::closeSession));

        try {
            HibernateSession.getSession();
            Menu.menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
