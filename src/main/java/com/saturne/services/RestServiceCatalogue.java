package com.saturne.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.saturne.entities.Formation;


@Path("/catalogueservices")
public class RestServiceCatalogue {

	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

	public RestServiceCatalogue() {}	
	
	/**
	 * Service: ajouter formation
	 * @param reference
	 * @param lieu
	 * @param interFormation
	 * @param duree
	 * @param prerequis
	 * @param objectif
	 * @param publicVise
	 * @param programmeDetaille
	 * @param servletResponse
	 * @return
	 * @throws IOException
	 */
	@POST
    @Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //#! TODO : replace w/ => consumes JSON => enlever @FormParam, adapter syntaxe
	public String addTraining(@FormParam("ref") String reference,
								@FormParam("location") String lieu, 
								@FormParam("interIntra") Boolean interFormation, 
								@FormParam("duration") int duree, 
								@FormParam("prerequis") String prerequis,
								@FormParam("goal") String objectif,
								@FormParam("targetPublic") String publicVise, 
								@FormParam("details") String programmeDetaille,
								@Context HttpServletResponse servletResponse) throws IOException {
		
		ctx.load("classpath:application-annotations.xml"); 
		//si on ne refresh pas le context, une expression Spring sera lev�e
		ctx.refresh();
	
		ServiceCatalogue sc=ctx.getBean("serviceCatalogue", ServiceCatalogue.class); //Injection de dépendance de ServiceContact dans RestServiceContact
		
		   if (sc==null)
		   {
				return "ServiceCatalogue is NULL";
		   }
			else
			{
				Formation f= new Formation(reference, lieu, interFormation, duree, prerequis, objectif, publicVise, programmeDetaille);
				sc.addTraining(f);
				servletResponse.sendRedirect("../addFormation.jsp");
				return "Appel du service 'addTraining'\n Formation: "+ f.getReference() + " added";
			}		
			
	}

	/**
	 * service get training (by reference)
	 * @param reference
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN) // OR//@Produces(MediaType.APPLICATION_JSON) ?? #!TODO	
	@Path("/{ref}")
	public String getTraining(@PathParam("ref")  String reference) { //# TODO: returns 'String' or 'Formation'??
		System.out.println("*****************************************");
		
		ctx.load("classpath:application-annotations.xml"); 
		//si on ne refresh pas le context, une expression Spring sera lev�e
		ctx.refresh();
	
		ServiceCatalogue sc=ctx.getBean("serviceCatalogue", ServiceCatalogue.class);
		
		if (sc==null)
			System.out.println("///////////////////////////////////////////////////////******");
		else
			sc.getTraining(reference);
		//System.out.println(contact);
		return "Formation "+ reference + ": "+ sc.getTraining(reference);
		//return "Test OK";
	}
	
	/***
	 * Service : get all the trainings
	 * @param reference
	 * @return string / OR ?? List<Formation
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN) // OR//@Produces(MediaType.APPLICATION_JSON) ?? #!TODO	
	@Path("/allTrainings")
	public String getAllTrainings() { //# TODO: returns 'String' or 'Formations'??
		System.out.println("*****************************************");
		String result="";
		ctx.load("classpath:application-annotations.xml"); 
		ctx.refresh();
	
		ServiceCatalogue sc=ctx.getBean("serviceCatalogue", ServiceCatalogue.class);
		List<Formation> trainings = new ArrayList<>();
		if (sc==null)
			System.out.println("///////////////////////////////////////////////////////******");
		else
			 trainings = sc.getAllTrainings();
		  for (Formation f: trainings) {
	            result+=f;
	        }
		return "Formations: "+ result;
		//return "Test OK";
	}
	
	

}
