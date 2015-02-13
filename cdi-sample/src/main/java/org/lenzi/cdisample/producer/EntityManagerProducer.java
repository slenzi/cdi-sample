package org.lenzi.cdisample.producer;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

	@PersistenceContext(unitName="OraclePersistenceUnit")
	private EntityManager oraEntityManager;	
	
	public EntityManagerProducer() { }
	
	@Produces
	@Default
	public EntityManager getOracleEntityManager(){
		return oraEntityManager;
	}
	
    protected void closeEntityManager(@Disposes @Default EntityManager entityManager){
        if (entityManager.isOpen()){
            entityManager.close();
        }
    }

}
