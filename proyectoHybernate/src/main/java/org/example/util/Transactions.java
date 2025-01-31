package org.example.util;

import org.example.mapping.*;
import org.hibernate.Session;

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

    public static void insert() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transaction transaction = null;

        try {
            // transaction = session.beginTransaction();

            // Crear entidades
            Body body = new Body();
            Infrastructure infrastructure = new Infrastructure();
            Replika replika = new Replika();

            session.save(body);
            session.save(infrastructure);
            session.save(replika);

            // Consultar entidades
            Body bodyConsultado = session.get(Body.class, body.getId());
            System.out.println(bodyConsultado);

            Infrastructure infConsultada = session.get(Infrastructure.class, infrastructure.getId());
            System.out.println(infConsultada);

            Replika replikaConsultada = session.get(Replika.class, replika.getId());
            System.out.println(replikaConsultada);

            // transaction.commit();
        } catch (Exception e) {
            // if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
