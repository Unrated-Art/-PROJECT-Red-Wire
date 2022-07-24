package com.services;

import java.util.ArrayList;
import java.util.List;

import com.daos.DAOCatalogue;
import com.entities.charline.Catalogue;
import com.entities.jeanmanno.Formation;

public class ServiceCatalogue {

	public ServiceCatalogue() {
	// TODO Auto-generated constructor stub
}


	/**
	 * Rechercher une formation et l'afficher
	 * @param reference
	 */
	public void getTraining(String reference) { 
		DAOCatalogue dc= new DAOCatalogue();
		Formation f = dc.getTraining(reference);
		/*String reference, String lieu, Boolean interFormation, int duree, String prerequis,
		String objectif, String publicVise, String programmeDetaille*/
		System.out.println("id= "+ f.getIdFormation() +", lieu= "+f.getLieu()+", interformation="+f.getInterFormation()+" ,durée="
							+ f.getDuree() +" ,prérequis="+ f.getPrerequis() + ", objectif=" + f.getObjectif()
							+ ", public visé="+ f.getPublicVise() +" ,programme détaillé="+ f.getProgrammeDetaille());
		
	}
	
	/**
	 *  Rechercher toutes les formations
	 * @return
	 */
	public List<Formation> getAllTrainings() { 
		
		
		DAOCatalogue dc= new DAOCatalogue();
		
		
		List<Formation> formations = dc.getAllTrainings();
//		System.out.println("id= "+ f.getIdFormation() +", lieu= "+f.getLieu()+", interformation="+f.getInterFormation()+" ,durée="
//							+ f.getDuree() +" ,prérequis="+ f.getPrerequis() + ", objectif=" + f.getObjectif()
//							+ ", public visé="+ f.getPublicVise() +" ,programme détaillé="+ f.getProgrammeDetaille());
		
		return formations;
	}
	
	
	

	/**
	 * Supprimer une formation 
	 * @param idFormation
	 */
	public void deleteTraining(long idFormation) { 
		DAOCatalogue dc= new DAOCatalogue();
		int res = dc.deleteTraining(idFormation);
		if (res == 1) {
			System.out.println("La formation ayant comme id: "+idFormation+" a été supprimée");
		}
	
	}
	
	
//	@Override
//	public ArrayList<Formation> getTrainingByReference(String reference) {
//
//		ArrayList<Contact> contacts = new ArrayList<Contact>();
//
//		ResultSet rec = null;
//		Connection con = null;
//		try {
//			Class.forName(Messages.getString("driver"));
//			con = DriverManager.getConnection(Messages.getString("database"), Messages.getString("username"),
//					Messages.getString("password"));
//			Statement stmt = con.createStatement();
//			rec = stmt.executeQuery("SELECT * FROM contacts WHERE lastname = " + "'" + lastname + "'");
//
//			while (rec.next()) {
//				Contact contact = new Contact();
//				contact.setIdContact(Long.parseLong(rec.getString("id")));
//				contact.setFirstName(rec.getString("firstname"));
//				contact.setLastName(rec.getString("lastname"));
//				contact.setEmail(rec.getString("email"));
//				contacts.add(contact);
//			}
//
//			stmt.close();
//			rec.close();
//			con.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return contacts;
//	}

	

}
