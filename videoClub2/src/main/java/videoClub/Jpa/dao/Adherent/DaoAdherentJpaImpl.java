package videoClub.Jpa.dao.Adherent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClub.Jpa.model.Adherent;
import videoClub.Jpa.util.Context;

public class DaoAdherentJpaImpl implements DaoAdherent {

	@SuppressWarnings("unchecked") 
	public List<Adherent> findAll() {
		List<Adherent> personnes = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Adherent a"); //"from Personne p" fonctionne aussi
		personnes=query.getResultList();
		em.close();
		return personnes;
	}

	public Adherent findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Adherent p = null;
		p = em.find(Adherent.class, key);
		em.close();
		return p;
	}

	public void insert(Adherent obj) {
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

	public void update(Adherent obj) {
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

	public void delete(Adherent objet) {
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
			em.remove(em.find(Adherent.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}
}
