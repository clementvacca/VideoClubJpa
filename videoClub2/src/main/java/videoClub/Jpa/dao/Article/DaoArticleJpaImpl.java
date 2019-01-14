package videoClub.Jpa.dao.Article;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import videoClub.Jpa.model.Article;
import videoClub.Jpa.util.Context;

public class DaoArticleJpaImpl implements DaoArticle {

	@SuppressWarnings("unchecked") 
	public List<Article> findAll() {
		List<Article> articles = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Article a"); //"from Personne p" fonctionne aussi
		articles=query.getResultList();
		return articles;
	}

	public Article findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Article o = null;
		o = em.find(Article.class, key);
		em.close();
		return o;
	}

	public void insert(Article obj) {
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

	public void update(Article obj) {
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

	public void delete(Article objet) {
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
			em.remove(em.find(Article.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
