package com.poe.poe2220718.poe20220718.tigres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
    
    private static EntityManager entityManager;
    
    public static EntityManager getEntityManager() {
        
        if(entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tigres");
            entityManager = entityManagerFactory.createEntityManager();
        }
        
        return entityManager;
    }
}
