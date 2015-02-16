package org.lenzi.cdisample.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Transient;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.lenzi.cdisample.model.Person;
import org.lenzi.cdisample.model.Person_;
import org.slf4j.Logger;

/**
 * Repository for person data...
 * 
 * @author sal
 *
 */
@Repository
public class PersonRepository extends AbstractRepository implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -5619951818085361996L;
	
	@Inject
	private Logger logger;

	public PersonRepository() {
		
	}
	
	/**
	 * Fetch person by person ID.
	 * 
	 * @param id - The person ID.
	 * @return
	 */
	public Person getPersonById(int id){
		
		logger.info("Fetching person by person id = " + id);
		
		logger.debug("Getting entity manager.");
		//EntityManager pgEm = getEntityManager();
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> query	= cb.createQuery(Person.class);
		Root<Person> root = query.from(Person.class);
		
		//Metamodel meta = getEntityManager().getMetamodel();
		//EntityType<Person> Per_ = meta.entity(Person.class);
	
		query.select(root).where(cb.equal(root.get(Person_.personId), id));
	
		Person p = null;
		try{
			
			logger.debug("Running query.");
			p = entityManager.createQuery(query).getSingleResult();
			logger.debug("Query execution complete.");
			
		} catch (NoResultException e){
			logger.error("Error querying person for person id " + id + ". " + e.getMessage());
			return null;
		}
		if(p == null){
			logger.warn("No person returned from database for person id " + id);
		}
		return p;
	}

}
