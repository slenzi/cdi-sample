package org.lenzi.cdisample.webservice;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.lenzi.cdisample.db.model.Person;
import org.lenzi.cdisample.service.PersonService;
import org.slf4j.Logger;

/**
 * JAX-RS service for managing person resources.
 * 
 * @author slenzi
 *
 */
@ManagedBean
@ApplicationScoped
@Path("/person")
public class PersonResource {

	@Inject
	private Logger logger;
	
	@Inject
	private PersonService personService;
	
	/**
	 * Get service name
	 * 
	 * @return JSON object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getServiceName(){
		return PersonResource.class.getName();
	}
	
	/**
	 * Fetch person by id
	 * 
	 * @param id - The ID of the person.
	 * @return JSON object
	 */
	@GET
	@Path("{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonById(@PathParam("sid") String id){
		
		logger.debug(PersonResource.class.getName() + " fetch person by id = " + id);
		
		Integer personId = null;
		try {
			personId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			logger.error("Error parsing person ID parameter: " + e.getMessage());
			throw new IllegalArgumentException("Please provide a valid person ID.");
		}
		
		Person per = personService.getPersonById(personId.intValue());
		return per;
	}
	
}
