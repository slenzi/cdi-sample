package org.lenzi.cdisample.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.inject.Inject;




import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lenzi.cdisample.bean.Hello;
import org.lenzi.cdisample.repository.PersonRepository;

@WebServlet(urlPatterns = "/sample")
public class SampleController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2983722664341370862L;
	
	@Inject
	private Hello hello;
	
	@Inject
	private PersonRepository personRepository;

	public SampleController() {}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        out.println(getHelloMessage());
        out.close();
	}
	
	/**
	 * Get our hello message.
	 * 
	 * @return
	 */
	public String getHelloMessage(){
		
		boolean haveHello = ((hello != null) ? true : false);
		boolean havePersonRepository = ((personRepository != null) ? true : false);
		boolean haveEntityManager = havePersonRepository && personRepository.haveEntityManager();
		
		StringBuffer buff = new StringBuffer();
		buff.append( ((haveHello) ? hello.getHello() : "Boo... no CDI injection.") ).append("\n")
			.append( ((havePersonRepository) ? "Have person repository" : "Boo... no person respository.") ).append("\n")
			.append( ((haveEntityManager) ? "Yay! Have entity manager" : "Boo...no entity manager") ).append("\n");
		
		return buff.toString();
	}

}
