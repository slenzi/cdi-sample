package org.lenzi.cdisample.repository;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
@Target({
    METHOD, FIELD, PARAMETER, TYPE
})
public @interface PostgresUnit {

}
