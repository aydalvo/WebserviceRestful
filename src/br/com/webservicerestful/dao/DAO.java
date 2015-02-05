package br.com.webservicerestful.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * 
 * WebserviceRestful - br.com.webservicerestful.dao - DAO.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 08/09/2014 10:47:01
 * @version 1.0
 * @param <T>
 *
 */

public class DAO<T> {
	
	private EntityManager em;
	
	private final Class<T> classe;

	public DAO(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}
	
	public void adiciona(T t) {
		em.persist(t);
	}
	
	public void remove(T t) {
		
	}
	
	public T busca(Integer id) {
		return em.getReference(classe, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> lista() {
		return em.createQuery("select e from " + classe.getName() + " e").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaComCoordenada() {
		return em.createQuery("select e from " + classe.getName() + " e join fetch e.coordenada").getResultList();
	}
	
}
