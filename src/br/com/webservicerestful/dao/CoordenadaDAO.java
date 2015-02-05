package br.com.webservicerestful.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.webservicerestful.modelo.Coordenada;

/**
 * 
 * WebserviceRestful - br.com.webservicerestful.dao - CoordenadaDAO.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 09/09/2014 14:12:52
 * @version 1.0
 *
 */


public class CoordenadaDAO {
	
	private final DAO<Coordenada> dao;
	
	public CoordenadaDAO(EntityManager em) {
		dao  =  new DAO<Coordenada>(em, Coordenada.class);
	}
	
	public void salva(Coordenada coordenada) {
		dao.adiciona(coordenada);
	}
	
	public Coordenada busca(Integer id) {
		return dao.busca(id);
	}
	
	public void exclui(Coordenada coordenada) {
		dao.remove(coordenada);
	}
	
	public List<Coordenada> lista() {
		return dao.lista();
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 09/09/2014 14:12:53
	 * @version 1.0
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
