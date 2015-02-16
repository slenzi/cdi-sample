package org.lenzi.cdisample.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.lenzi.cdisample.db.repository.PostgresUnit;

@ApplicationScoped
public class EntityManagerProducer {

	//@PersistenceContext(unitName="PostgresPersistenceUnit")
	//private EntityManager postgresEntityManager;
	
	@Inject
	private EntityManagerFactory emf;
	
	@Produces
	@RequestScoped
	@PostgresUnit
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	/*
	@Produces
	@RequestScoped
	@PostgresUnit
	public EntityManager getPostgresEntityManager(){
		if(postgresEntityManager == null){
			throw new RuntimeException("Entity Manager not started.");
		}
		return postgresEntityManager;
	}
	*/
	
	
    protected void closeEntityManager(@Disposes @PostgresUnit EntityManager entityManager){
        if (entityManager.isOpen()){
            entityManager.close();
        }
    }
    

}
