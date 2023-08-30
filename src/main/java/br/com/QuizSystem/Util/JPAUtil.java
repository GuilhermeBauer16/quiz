package br.com.QuizSystem.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("quiz");

    public EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

}
