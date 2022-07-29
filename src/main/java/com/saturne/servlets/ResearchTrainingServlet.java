package com.saturne.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saturne.entities.Formation;
import com.saturne.services.ServiceCatalogue;

/**
 * Servlet implementation class ResearchTrainingServlet
 */
@WebServlet("/ResearchTrainingServlet")
public class ResearchTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Hello from doPost() de ResearchTrainingServlet");
		//récupérer le request
		String ref = request.getParameter("reference");
		ServiceCatalogue sc = new ServiceCatalogue();
		Formation f= new Formation();
		//recupérer la formation dont la référence = ref
		f = sc.getTraining(ref);
		response.getWriter().append("Got the training where ref=" + ref);
//		("id= "+ f.getIdFormation() +", lieu= "+f.getLieu()+", interformation="+f.getInterFormation()+" ,durée="
//				+ f.getDuree() +" ,prérequis="+ f.getPrerequis() + ", objectif=" + f.getObjectif()
//				+ ", public visé="+ f.getPublicVise() +" ,programme détaillé="+ f.getProgrammeDetaille());
//		
		//récupérer/afficher toutes les formations du catalogue
		sc.getAllTrainings();
		/**
		 * Idea!!!!!
		 */
		
//		for (String s: list) {
//        System.out.println(s);
//    	}
		//while (sc.getAllTrainings().next()) {
			//rajouter affichage avec html pour chaque element de la liste récuperée via getAllTrainings
		//}
		
		//response ???
	
	}

}
