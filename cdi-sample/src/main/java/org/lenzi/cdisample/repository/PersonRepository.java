package org.lenzi.cdisample.repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.lenzi.cdisample.model.Person;

/**
 * Repository for person data...
 * 
 * @author sal
 *
 */
@Repository
public class PersonRepository extends AbstractRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5619951818085361996L;

	public PersonRepository() {
		
	}
	
	public Person getPersonById(int id){
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Person> query	= cb.createQuery(Person.class);
		Root<Person> root = query.from(Person.class);
		ParameterExpression<Integer> p = cb.parameter(Integer.class);
		query.select(root).where(cb.equal(root.get("personId"), p));
		//query.
		
		try{
			return getEntityManager().createQuery(query).getSingleResult();
		} catch (NoResultException e){
			return null;
		}		
	}

}
