package com.saturne.servlets;

import java.io.IOException;
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
 * Servlet implementation class AddFormationServlet
 */
@WebServlet("/AddTrainingServlet")
public class AddTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ProgrammePrincipal.class);


    /**
     * Default constructor. 
     */
    public AddTrainingServlet() {
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
		
		/**
		 * 		f.setIdFormation(rec.getLong("idTraining"));
//				f.setReference(rec.getString("ref"));
//				f.setLieu(rec.getString("location"));
//				f.setInterFormation(rec.getBoolean("interTraining"));
//				f.setDuree(rec.getInt("duration"));
//				f.setPrerequis(rec.getString("requirements"));
//				f.setObjectif(rec.getString("goal"));
//				f.setPublicVise(rec.getString("targetAudience"));
//				f.setProgrammeDetaille(rec.getString("details"));
		 */
		//long id = Long.parseLong(request.getParameter("id"));
		String reference = request.getParameter("ref");
		String lieu = request.getParameter("location");
		boolean interF = Boolean.parseBoolean(request.getParameter("interIntra"));
		int duree = Integer.parseInt(request.getParameter("duration"));
		String preR = request.getParameter("prerequis");
		String obj = request.getParameter("goal");
		String publicV = request.getParameter("targetPublic");
		String progr = request.getParameter("details");
		
		Formation f= new Formation(reference, lieu, interF, duree, preR, obj, publicV, progr);
		log.trace("hello from doPost of AddTrainingServlet: Training persisted to database SATURNE");
		ServiceCatalogue sc = new ServiceCatalogue();
		sc.addTraining(f);
		
		response.getWriter().append(f.toString());
		
	}

}
