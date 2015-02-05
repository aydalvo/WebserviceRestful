package br.com.webservicerestful.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.webservicerestful.dao.CidadeDAO;
import br.com.webservicerestful.infra.JPAUtil;
import br.com.webservicerestful.modelo.Cidade;

public class CidadeController {
	
	ArrayList<Cidade> cidades;
	
	/**
	 * @return the cidades
	 */
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}
	
	/**
	 * @param cidades the cidades to set
	 */
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Collection<Cidade> listarTodos(){
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		CidadeDAO cidadeDAO = new CidadeDAO(em);
		List<Cidade> listaDeCidades = cidadeDAO.lista();
		em.close();
		return listaDeCidades;
	}
	
	public Cidade buscar(String codigo) {
		
//		setCidades(CidadeFakeDAO.getInstance().listarTdos2());
		
		return getCidades().get(Integer.parseInt(codigo));
	}
	
	public CidadeController criaInstancia() {
		return new CidadeController();
	}

}
