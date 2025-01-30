package org.example.util;

import org.example.mapping.Master;

public class Program {
    public static void flux() {
        try {
            HibernateSession.getSession();

            Master master = Transactions.read();
            String output = master.toString();
            System.out.println(output);

            HibernateSession.closeSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
