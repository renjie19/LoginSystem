package com.lourence.jonh.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Hibernate {
//    private static Hibernate hibernate;
    private final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("UsersDB");
    private final EntityManager ENTITYMANAGER = FACTORY.createEntityManager();
//    private Hibernate() {
//
//    }
//
//    public static Hibernate getInstance() {
//        if(hibernate ==null) {
//            hibernate = new Hibernate();
//        }
//        return hibernate;
//    }

    public void persist(Object object) {
        ENTITYMANAGER.getTransaction().begin();
        ENTITYMANAGER.persist(object);
        ENTITYMANAGER.getTransaction().commit();
        closeConnection();
    }

    public void merge(Object object) {
        ENTITYMANAGER.getTransaction().begin();
        ENTITYMANAGER.merge(object);
        ENTITYMANAGER.getTransaction().commit();
        closeConnection();
    }

    public Object find(Class type,int id) {
        ENTITYMANAGER.getTransaction().begin();
        Object object = ENTITYMANAGER.find(type,id);
        ENTITYMANAGER.getTransaction().commit();
        closeConnection();
        return object;
    }

    public void remove(Class type,int id) {
        ENTITYMANAGER.getTransaction().begin();
        Integer primaryKey = id;
        ENTITYMANAGER.remove(ENTITYMANAGER.getReference(type, primaryKey));
        ENTITYMANAGER.getTransaction().commit();
        closeConnection();
    }

    public List createNamedQuery(String queryString) {
        return ENTITYMANAGER.createQuery(queryString).getResultList();
    }

    public Object getObjectNamedQuery(String queryString) {
        try {
           return ENTITYMANAGER.createQuery(queryString).getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public void createNativeQuery(String query) {
        ENTITYMANAGER.getTransaction().begin();
        ENTITYMANAGER.createNativeQuery(query).executeUpdate();
        ENTITYMANAGER.getTransaction().commit();
        closeConnection();
    }

    public void closeConnection() {
        ENTITYMANAGER.close();
        FACTORY.close();
    }
}
