package org.example.main;

import org.example.mapping.Entidad;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Crear una nueva entidad
            Entidad entidad = new Entidad("Ejemplo");
            session.save(entidad);

            // Consultar entidades
            Entidad entidadConsultada = session.get(Entidad.class, entidad.getId());
            System.out.println(entidadConsultada);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}