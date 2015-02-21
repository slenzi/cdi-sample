package org.lenzi.cdisample.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Dependent
public class LoggerProducer {

	/**
	 * The logger will be created with the class name of the class that it was
	 * injected into, aka the injection point.
	 * 
	 * @param injectionPoint
	 * @return
	 */
	@Produces
	public Logger getLogger(InjectionPoint injectionPoint){
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
}
