package br.com.webservicerestful.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.webservicerestful.modelo.Cidade;

/**
 * 
 * WebserviceRestful - br.com.webservicerestful.dao - CidadeDAO.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 08/09/2014 10:37:49
 * @version 1.0
 *
 */

public class CidadeDAO {
	
	private final DAO<Cidade> dao;
	
	public CidadeDAO(EntityManager em) {
		dao  =  new DAO<Cidade>(em, Cidade.class);
	}

	public void salva(Cidade cidade) {
		dao.adiciona(cidade);
	}
	
	public Cidade busca(Integer id) {
		return dao.busca(id);
	}
	
	public void exclui(Cidade cidade) {
		dao.remove(cidade);
	}
	
	public List<Cidade> lista() {
		return dao.lista();
	}
	
	public List<Cidade> listaComCoordenada() {
		return dao.listaComCoordenada();
	}
	
}
