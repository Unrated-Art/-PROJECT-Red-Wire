package com.saturne.daos;

import com.saturne.entities.Catalogue;
import com.saturne.entities.Formation;
import com.saturne.util.JpaUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;

public class DAOCatalogue implements IDAOCatalogue {

  @Override
  public Formation getTraining(String reference) { //rechercher une formation
    EntityManager em = JpaUtil.getEmf().createEntityManager();

    Formation f = em.find(Formation.class, reference);

    return (f);
  }

  @Override
  public int deleteTraining(long id) {
    int success = 0;
    try {
      EntityManager em = JpaUtil.getEmf().createEntityManager();
      em.getTransaction().begin();

      Formation f = em.find(Formation.class, id);
      em.remove(f);

      em.getTransaction().commit();
      em.close();
      System.out.println(f + "supprimée!");
    } catch (Exception e) {
      e.printStackTrace();
    }

    return success;
  }

  @Override
  public ArrayList<Formation> getAllTrainings() {
    ArrayList<Formation> allTrainings = new ArrayList<Formation>();

    ResultSet rec = null;
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/SATURNE",
          "root",
          "root"
        );

      Statement stmt = con.createStatement();
      rec = stmt.executeQuery("SELECT * FROM trainings");

      System.out.println("Connected to database and all trainings selected");
      //log.trace("Connected to database and all trainings selected");

      while (rec.next()) {
        Formation f = new Formation();
        /*String reference, String lieu, Boolean interFormation, int duree, String prerequis,
			String objectif, String publicVise, String programmeDetaille*/

        f.setIdFormation(rec.getLong("idTraining"));
        f.setReference(rec.getString("ref"));
        f.setLieu(rec.getString("location"));
        f.setInterFormation(rec.getBoolean("interTraining"));
        f.setDuree(rec.getInt("duration"));
        f.setPrerequis(rec.getString("requirements"));
        f.setObjectif(rec.getString("goal"));
        f.setPublicVise(rec.getString("targetAudience"));
        f.setProgrammeDetaille(rec.getString("details"));

        allTrainings.add(f);
        System.out.println("formation n°" + f.getIdFormation() + " ajoutée ");
      }

      stmt.close();
      rec.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return allTrainings;
  }
}
