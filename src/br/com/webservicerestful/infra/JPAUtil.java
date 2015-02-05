package br.com.webservicerestful.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * WebService - br.com.webservice.infra - JPAUtil.java
 *
 * Classe responsável por instanciar o EntityMenager.
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 08/09/2014 10:33:41
 * @version 1.0
 *
 */

public class JPAUtil {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebserviceRestful");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
