package org.lenzi.cdisample.bean;

import javax.enterprise.context.RequestScoped;

import org.joda.time.LocalDateTime;

@RequestScoped
public class Hello {

	public String getHello(){
		return (new LocalDateTime()).toString() +  ". Hello CDI! ";
	}

}
