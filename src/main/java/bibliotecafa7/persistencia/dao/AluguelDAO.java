package bibliotecafa7.persistencia.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import bibliotecafa7.modelo.Emprestimo;
import bibliotecafa7.persistencia.repositorios.AluguelRepositorio;

public class AluguelDAO extends GenericDAO<Emprestimo> implements AluguelRepositorio {
	
	@Override
	public boolean persist(Emprestimo t)
			throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		// TODO Auto-generated method stub
		return super.persist(t);
	}
	
	@Override
	public Emprestimo find(int pk) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return super.find(pk);
	}
	
	@Override
	public boolean merge(Emprestimo t) throws IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		return super.merge(t);
	}
	

}
