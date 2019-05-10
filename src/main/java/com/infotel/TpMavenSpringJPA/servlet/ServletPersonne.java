package com.infotel.TpMavenSpringJPA.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.TpMavenSpringJPA.metier.Personne;
import com.infotel.TpMavenSpringJPA.service.Iservice;
import com.infotel.TpMavenSpringJPA.service.ServiceImpl;


/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     String nom=null;
		     String prenom = null;
		     int age=0;
		     Iservice service = context.getBean("serviceImpl", ServiceImpl.class);
			 int id = 0;
		     //1- récuperer les données
			if(request.getParameter("lastname")!=null)
			{
				 nom = request.getParameter("lastname");
				 prenom = request.getParameter("firstname");
				 age = Integer.parseInt(request.getParameter("age"));
	
				
				//2- envoyer � la couche service
				Personne p = context.getBean("personne", Personne.class);
				p.setAge(age);
				p.setNom(nom);
				p.setPrenom(prenom);
				if(request.getParameter("ajouter")!=null)
					{
					service.ajouterPersonne(p);
					}
				if (request.getParameter("modifier")!=null)
				{
					id = Integer.parseInt(request.getParameter("id"));
					p.setId(id);
					service.modifierPersonne(p);
				}
			}	
				request.setAttribute("personnes", service.findAllPersonnes());
				//4- appel de la jsp
				request.getRequestDispatcher("personne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
