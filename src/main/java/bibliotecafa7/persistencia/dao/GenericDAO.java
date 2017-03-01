package bibliotecafa7.persistencia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import bibliotecafa7.persistencia.util.JPAUtil;

/**
 * Classe abstrata responsável por fornecer encapsulamento no acesso aos dados.
 */
public abstract class GenericDAO<T> {
	private Class<T> persistentClass;

	/**
	 * Método responsável pela instanciação e extração da classe persistente.
	 */
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * Método responsável pela persistência de uma instância da classe
	 * persistente.
	 * 
	 * @param t
	 *            T
	 * @return Boolean
	 * @throws EntityExistsException
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 * @throws PersistenceException
	 */
	public boolean persist(T t)
			throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		EntityManager em = JPAUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return true;
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (IllegalArgumentException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (TransactionRequiredException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * Método responsável pela atualização de uma instância da classe
	 * persistente.
	 * 
	 * @param t
	 *            T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean merge(T t) throws IllegalArgumentException, TransactionRequiredException {
		EntityManager em = JPAUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (TransactionRequiredException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * Método responsável pela remoção de uma instância da classe persistente.
	 * 
	 * @param t
	 *            T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean remove(T t) throws IllegalArgumentException, TransactionRequiredException {
		EntityManager em = JPAUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			em.getTransaction().rollback();
			throw e;
		} catch (TransactionRequiredException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	/**
	 * Método responsável pela busca de uma instância da classe persistente pela
	 * chave-primária.
	 * 
	 * @param pk
	 *            Integer
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public T find(int pk) throws IllegalArgumentException {
		EntityManager em = JPAUtil.getEntityManager();

		try {
			return em.find(this.persistentClass, pk);
		} finally {
			em.close();
		}
	}

	/**
	 * Método responsável pela busca de uma instância da classe persistente pela
	 * chave-primária.
	 * 
	 * @param pk
	 *            String
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public T find(String pk) throws IllegalArgumentException {
		EntityManager em = JPAUtil.getEntityManager();

		try {
			return em.find(this.persistentClass, pk);
		} finally {
			em.close();
		}
	}

	/**
	 * Método responsável pela listagem de instâncias da classe persistente.
	 * 
	 * @return List<T>
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public Set<T> list() throws IllegalArgumentException {
		EntityManager em = JPAUtil.getEntityManager();

		try {
			return new HashSet<T>(em.createQuery("from " + this.persistentClass.getSimpleName()).getResultList());
		} finally {
			em.close();
		}
	}

}
