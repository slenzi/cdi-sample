package org.lenzi.cdisample.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.lenzi.cdisample.webservice.PersonResource;

/**
 * Bootstrap JAX-RS services
 * 
 * @author slenzi
 *
 */
@ApplicationPath("/rest")
public class MyJerseyApp extends Application {

	/* (non-Javadoc)
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(PersonResource.class);
		return classes;
	}



}
