package org.lenzi.cdisample.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lenzi.cdisample.repository.PostgresUnit;

//@ApplicationScoped
//@SessionScoped
public class EntityManagerProducer {

	@PersistenceContext(unitName="PostgresPersistenceUnit")
	private EntityManager postgresEntityManager;
	
	//@RequestScoped
	//@Produces
	//@Default
	//@Dependent
	
	@Produces
	@RequestScoped
	@PostgresUnit
	public EntityManager getPostgresEntityManager(){
		if(postgresEntityManager == null){
			throw new RuntimeException("Entity Manager not started.");
		}
		return postgresEntityManager;
	}
	
    protected void closeEntityManager(@Disposes @PostgresUnit EntityManager entityManager){
        if (entityManager.isOpen()){
            entityManager.close();
        }
    }

}
