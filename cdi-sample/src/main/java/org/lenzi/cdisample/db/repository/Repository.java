package org.lenzi.cdisample.db.repository;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * Custom stereotype which provides a transactional context using 
 * Apache Deltapike JPA transactional implementation.
 * 
 * @author slenzi
 */
@Named
@ApplicationScoped
@Transactional
@Stereotype
@Target({TYPE, METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface Repository {

}
