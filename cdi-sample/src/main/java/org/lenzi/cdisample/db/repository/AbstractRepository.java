package org.lenzi.cdisample.db.repository;

import java.io.Serializable;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

import org.slf4j.Logger;

public class AbstractRepository implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -7142560902806805291L;
	
	@Inject
	private Logger logger;
	
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
	
	public void debugEntityManager(){
		if(!haveEntityManager())
			return;
		logger.debug("Entity manager debug info:");
		Map<String,Object> managerProp = entityManager.getProperties();
		for(String s : managerProp.keySet()){
			logger.debug(managerProp.get(s).toString());
		}
	}

}
