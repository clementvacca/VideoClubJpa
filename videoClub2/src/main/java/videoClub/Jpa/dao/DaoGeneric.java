package videoClub.Jpa.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
	public List<T> findAll(); // on r�cup�re un type g�n�rique

	public T findByKey(K key);

	public void insert(T obj);

	public void update(T obj);

	public void delete(T objet);

	public void deleteByKey(K key);
}
