package org.example.util;

import org.example.mapping.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class Transactions {

    private static final Session sesh = HibernateSession.getSession();

    public static Master read() {
        BodyList bodyList = new BodyList();
        InfList infList = new InfList();
        AssignedReplikaList assignedReplikaList = new AssignedReplikaList();
        ReplikaList replikaList = new ReplikaList();

        bodyList.setBodyList((ArrayList<Body>) sesh.createQuery("FROM Body", Body.class).list());
        infList.setInfrastructureList((ArrayList<Infrastructure>) sesh.createQuery("FROM Infrastructure", Infrastructure.class).list());
        assignedReplikaList.setAssignedReplikaList((ArrayList<AssignedReplika>) sesh.createQuery("FROM AssignedReplika", AssignedReplika.class).list());
        replikaList.setReplikaList((ArrayList<Replika>) sesh.createQuery("FROM Replika", Replika.class).list());

        return new Master(bodyList, infList, assignedReplikaList , replikaList);
    }

    public static void create(ArrayList<Object> items) {
        Transaction transaction = null;

        try {
            for (Object object : items) {
                transaction = sesh.beginTransaction();
                sesh.save(object);
                transaction.commit();
            }

            System.out.println("\n\033[1;32mEntity/s inserted correctly\033[0m");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating entity: " + e.getMessage());
        }
    }

    public static void update(Object object) {
        Transaction transaction = null;

        try {
            transaction = sesh.beginTransaction();
            sesh.update(object);
            transaction.commit();

            System.out.println("\n\033[1;32mEntity updated correctly\033[0m");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating entity: " + e.getMessage());
        }
    }

    public static void delete(Object object) {
        Transaction transaction = null;

        try {
            transaction = sesh.beginTransaction();
            sesh.delete(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error deleting entity: " + e.getMessage());
        }
    }

    public static void find(Object object, String search) {
        try {
            if (sesh.get(Object.class, search) != null) {
                System.out.println("Entity found: " + object);
            } else {
                System.out.println("Entity not found with query: " + "'" + search + "'");
            }
        } catch (Exception e) {
            System.err.println("Error searching for entity: " + e.getMessage());
        }
    }
}

