package org.lenzi.cdisample.listener;

import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Initializes the persistence unit / entity manager factor. Needed for Tomcat (non EE server.)
 * 
 * @author slenzi
 *
 */
public class CdiSampleContextListener implements ServletContextListener {

	public CdiSampleContextListener() {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent context) {
	

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		
		// initialize persistence unit
		Persistence.createEntityManagerFactory("PostgresPersistenceUnit");

	}

}
