package bibliotecafa7.persistencia.dao;

import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import bibliotecafa7.modelo.Livro;
import bibliotecafa7.persistencia.repositorios.LivroRepositorio;
import bibliotecafa7.persistencia.util.JPAUtil;

public class LivroDAO extends GenericDAO<Livro> implements LivroRepositorio {

	@Override
	public boolean persist(Livro t)
			throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		// TODO Auto-generated method stub
		return super.persist(t);
	}

	@Override
	public boolean merge(Livro t) throws IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		return super.merge(t);
	}

	@Override
	public Livro find(int pk) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return super.find(pk);
	}

	@Override
	public boolean remove(Livro t) throws IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		return super.remove(t);
	}
	
	@Override
	public Set<Livro> list() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return super.list();
	}

}
