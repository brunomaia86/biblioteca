package bibliotecafa7.persistencia.dao;

import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import bibliotecafa7.modelo.Usuario;
import bibliotecafa7.persistencia.repositorios.UsuarioRepositorio;

public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioRepositorio {
	
	@Override
	public Set<Usuario> list() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return super.list();
	}
	
	@Override
	public boolean persist(Usuario t)
			throws EntityExistsException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		// TODO Auto-generated method stub
		return super.persist(t);
	}

	@Override
	public boolean merge(Usuario t) throws IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		return super.merge(t);
	}
}
