package com.poe.poe2220718.poe20220718.tigres;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class TigreDAO {
    
    public static void create(Tigre newTigre) {
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        entityManager.persist(newTigre);//save()
        tx.commit();      
    }
    
    public static Tigre findById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        
        return entityManager.find( Tigre.class, id);
    }
    
    public static List<Tigre> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        
        Query query = entityManager.createQuery("SELECT t from Tigre t");
        return query.getResultList();
        
    }
    
    public static List<Tigre> findAllByName(String nomRecherche) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        
        Query query = entityManager.createQuery("SELECT t from Tigre t where t.nom = :nomrecherche");
        query.setParameter("nomrecherche", nomRecherche);
        return query.getResultList();
        
    }

    
    public static void deleteById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        Query query = entityManager.createQuery("DELETE from Tigre t where t.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        
        entityManager.clear();
        
        tx.commit();
    }

    public static void deleteAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        Query query = entityManager.createQuery("DELETE from Tigre t");
        query.executeUpdate();
        
        entityManager.clear();
        
        tx.commit();
    }
}
