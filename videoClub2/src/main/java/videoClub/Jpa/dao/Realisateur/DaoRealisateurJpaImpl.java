package videoClub.Jpa.dao.Realisateur;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClub.Jpa.model.Realisateur;
import videoClub.Jpa.util.Context;

public class DaoRealisateurJpaImpl implements DaoRealisateur {

	@SuppressWarnings("unchecked") 
	public List<Realisateur> findAll() {
		List<Realisateur> realisateurs = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select r from Realisateur r"); //"from Personne p" fonctionne aussi
		realisateurs=query.getResultList();
		return realisateurs;
	}

	public Realisateur findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Realisateur o = null;
		o = em.find(Realisateur.class, key);
		em.close();
		return o;
	}

	public void insert(Realisateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();

	}

	public void update(Realisateur obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();

	}

	public void delete(Realisateur objet) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(objet));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Realisateur.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	
}
