package org.lenzi.cdisample.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerFactoryProducer {

	public static final String PERSISTENCE_UNIT_POSTGRES = "PostgresPersistenceUnit";
	
	@Produces
	public EntityManagerFactory getEntityManagerFactory(){
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_POSTGRES);
	}
	
	public void destroy(@Disposes EntityManagerFactory factory){
		factory.close();
	}

}