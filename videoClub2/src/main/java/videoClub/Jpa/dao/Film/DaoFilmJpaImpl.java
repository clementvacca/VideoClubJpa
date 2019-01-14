package videoClub.Jpa.dao.Film;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClub.Jpa.model.Film;
import videoClub.Jpa.util.Context;

public class DaoFilmJpaImpl implements DaoFilm {

	@SuppressWarnings("unchecked") 
	public List<Film> findAll() {
		List<Film> films = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select f from Film f"); //"from Personne p" fonctionne aussi
		films=query.getResultList();
		return films;
	}

	public Film findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Film o = null;
		o = em.find(Film.class, key);
		em.close();
		return o;
	}

	public void insert(Film obj) {
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

	public void update(Film obj) {
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

	public void delete(Film objet) {
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
			em.remove(em.find(Film.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
