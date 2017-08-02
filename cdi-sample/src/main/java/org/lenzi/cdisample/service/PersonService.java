package org.lenzi.cdisample.service;

import org.lenzi.cdisample.db.model.Person;

public interface PersonService {

	/**
	 * Fetch person by id
	 * 
	 * @param id - the person id
	 * @return Person object
	 */
	public Person getPersonById(int id);
	
}
