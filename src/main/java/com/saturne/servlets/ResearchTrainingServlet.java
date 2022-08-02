package com.saturne.servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.saturne.entities.Formation;
import com.saturne.launcher.ProgrammePrincipal;
import com.saturne.services.ServiceCatalogue;

/**
 * Servlet implementation class ResearchTrainingServlet
 */
@WebServlet("/ResearchTrainingServlet")
//@WebServlet(name="ResearchTrainingServlet", urlPattern={"/training", "/trainings", "/allTrainings"})
public class ResearchTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ResearchTrainingServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResearchTrainingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.setContentType("text/json");
		response.setContentType("text/html");
		
		log.trace("Hello from doGET() de ResearchTrainingServlet");
		//récupérer le request
		
		String ref = request.getParameter("reference");
		log.trace("reference="+ref);
		ServiceCatalogue sc = new ServiceCatalogue();
		
		if (ref==null || ref.length()==0/* || {ref:([a-zA-Z])*}*/) { //si la référence est vide, j'affiche toutes les formations
			/**
			 * Get all the trainings
			 */
			//int i = ref.indexOf(0)f
			ArrayList<Formation> allTrainings= (ArrayList<Formation>) sc.getAllTrainings();
			request.setAttribute("allTrainings", allTrainings); // Will be available as ${allTrainings} in JSP
			request.getRequestDispatcher("/searchFormation.jsp").forward(request, response);
			/*
			Writer w= response.getWriter();
			for (Formation t : allTrainings) {
				w.append(t.toString()+"\n");
			}*/
		}
		else	
		{//recupérer la formation dont la référence = ref
			
		
			Formation f = sc.getTraining(ref);
			request.setAttribute("ref", ref);
			if (f.getIdFormation()!=0) { //#!TODO: verif condition!!
				request.setAttribute("trainingRef", f); // Will be available as ${trainingRef} in JSP
				request.getRequestDispatcher("/searchFormation.jsp").forward(request, response);
				//response.getWriter().append("Got the training where ref=" + ref +"\n"+f.toString());
			}
			else
			{
				
				//response.getWriter().append("La formation dont la référence est:"+ref+" est introuvable!!");
			}
			
			/**
			 *pour récupéer la formation sous format json
			 * 
			 *  response.setContentType("text/json");
		        Formation f = new Formation();
		        f=sc.getTraining(ref); 
			 */
			   
			
		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		doGet(request, response);
	
	}

}
