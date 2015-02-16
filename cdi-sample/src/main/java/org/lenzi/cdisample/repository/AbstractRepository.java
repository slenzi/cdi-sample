package org.lenzi.cdisample.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AbstractRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7142560902806805291L;
	
	@Inject
	@PostgresUnit
	protected EntityManager entityManager;	
	
	public AbstractRepository() {
		
	}
	
	/**
	 * Get default entity manager
	 * 
	 * @return
	 */
	public EntityManager getEntityManager(){
		return entityManager;
	}
	
	/**
	 * True if entity manager is not null, false otherwise.
	 * 
	 * @return
	 */
	public boolean haveEntityManager(){
		return ((entityManager != null) ? true : false);
	}

}
