package br.com.webservicerestful.modelo;

import java.io.Serializable;


/**
 * 
 * WebService - br.com.webservice.model - CidadeAbstrata.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 07/09/2014 15:03:41
 * @version 1.0
 *
 */

public abstract class CidadeAbstrata implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	
	protected String codigo;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
