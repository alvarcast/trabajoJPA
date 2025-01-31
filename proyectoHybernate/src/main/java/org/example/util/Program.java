package org.example.util;

import org.example.mapping.Master;

public class Program {
    public static void flux() {
        try {
            HibernateSession.getSession();

            Menu.menu();

            HibernateSession.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
