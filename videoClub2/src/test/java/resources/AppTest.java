package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import videoClub.Jpa.dao.Adherent.Civilite;
import videoClub.Jpa.dao.Adherent.DaoAdherent;
import videoClub.Jpa.dao.Adherent.DaoAdherentFactory;
import videoClub.Jpa.dao.Adherent.Eleve;
import videoClub.Jpa.dao.Adherent.Formateur;
import videoClub.Jpa.dao.Adresse.Adresse;
import videoClub.Jpa.dao.Article.DaoCompetence;
import videoClub.Jpa.dao.Article.DaoCompetenceFactory;
import videoClub.Jpa.dao.Film.DaoFilm;
import videoClub.Jpa.dao.Film.DaoFilmFactory;
import videoClub.Jpa.model.Adherent;
import videoClub.Jpa.model.Competence;
import videoClub.Jpa.util.Context;
import videoClub.Jpa.model.Article;

public class AppTest {

	public static void main(String[] args) {
		DaoAdherent daoPersonne=DaoAdherentFactory.getInstance();
		
		Adherent clement= new Eleve("clement","vacca");
		clement.setCivilite(Civilite.M);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		try {
			clement.setDateNaissance(sdf.parse("16/01/1995"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		clement.setAdresse(new Adresse(6,"rue rougemont","75009","paris"));
		daoPersonne.insert(new Formateur("olivier","gozlan",15,true));
		
		daoPersonne.insert(clement);
		
		Adherent recherche= daoPersonne.findByKey(100);
		System.out.println(recherche);
		
		DaoFilm daoOrdinateur=DaoFilmFactory.getInstance();
		Article ordi=new Article("368",16);
		daoOrdinateur.insert(ordi);
		
		DaoCompetence daoCompetence=DaoCompetenceFactory.getInstance();
		Competence comp=new Competence("JAVA");
		daoCompetence.insert(comp);
		
		
		
		Context.close();
		
//		System.out.println("ok");
//		Personne clement = new Personne("clement", "vacca");
//		System.out.println(clement.getId());
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		// transaction pour ordre de modification
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			// rendre un objet persistant--> avoir une version de l'objet en base (insert)
//			em.persist(clement);
//			clement.setPrenom("aze");
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}
//		em.close();
//		
//		Personne recherche=null;
//		em=Context.getEntityManagerFactory().createEntityManager();
//		tx=em.getTransaction();
//		tx.begin();
//		//recherche=em.find(Personne.class, 100);
//		recherche=new Personne("aaa","");
//		System.out.println("----------------");
//		
//		recherche.setNom("azerty");
//		em.merge(recherche); //
//		tx.commit();
		
	}

}
