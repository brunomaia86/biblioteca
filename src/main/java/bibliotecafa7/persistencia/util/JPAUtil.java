package bibliotecafa7.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("biblioteca_pu");

	public static EntityManager getEntityManager() {
		EntityManager manager = factory.createEntityManager();

		return manager;
	}

}
