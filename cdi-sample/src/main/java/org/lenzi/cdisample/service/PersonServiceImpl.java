package org.lenzi.cdisample.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.lenzi.cdisample.model.Person;
import org.lenzi.cdisample.repository.PersonRepository;
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
		logger.debug("Have entity manager = " + personRepository.haveEntityManager());
		
		return personRepository.getPersonById(1);
	}

}
