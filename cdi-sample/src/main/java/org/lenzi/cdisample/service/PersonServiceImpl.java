package org.lenzi.cdisample.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.lenzi.cdisample.db.model.Person;
import org.lenzi.cdisample.db.repository.PersonRepository;
import org.slf4j.Logger;

/**
 * Service for interacting with people resources.
 * 
 * @author slenzi
 *
 */
@Service
public class PersonServiceImpl implements PersonService, Serializable {
	
	@Inject
	private Logger logger;
	
	@Inject
	private PersonRepository personRepository;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1544545899210198256L;

	public PersonServiceImpl() {
		
	}

	@Override
	public Person getPersonById(int id) {
		
		logger.debug("Fetching person by id = " + id);
		if(personRepository.haveEntityManager()){
			logger.debug("Have entity manager = " + personRepository.haveEntityManager());
			personRepository.debugEntityManager();
		}
		
		return personRepository.getPersonById(1);
	}

}
