package org.lenzi.cdisample.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lenzi.cdisample.bean.Hello;
import org.lenzi.cdisample.db.model.Person;
import org.lenzi.cdisample.service.PersonService;
import org.slf4j.Logger;

@WebServlet(urlPatterns = "/sample")
public class SampleController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2983722664341370862L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private Hello hello;
	
	@Inject
	private PersonService personService;

	public SampleController() {}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        out.println(testCDI());
        out.close();
	}
	
	/**
	 * Get our hello message.
	 * 
	 * @return
	 */
	public String testCDI(){
		
		logger.debug("testCDI() called");
		
		boolean haveHello = ((hello != null) ? true : false);
		boolean havePeopleService = ((personService != null) ? true : false);
		
		StringBuffer buff = new StringBuffer();
		buff.append( ((haveHello) ? hello.getHello() : "Boo... no CDI injection.") ).append("\n")
			.append( ((havePeopleService) ? "Yay! Have person service" : "Boo... no person service.") ).append("\n");
		
		logger.debug(buff.toString());
		
		Person per = null;
		if(havePeopleService){
			per = personService.getPersonById(1);
		}
		boolean havePerson = ((per != null) ? true : false);
		buff.append( ((havePerson) ? "Yay! Have person. " + per.getFirstName() + " " + per.getLastName() : "Boo...no person") ).append("\n");
		
		logger.debug(buff.toString());
		
		return buff.toString();
	}

}
