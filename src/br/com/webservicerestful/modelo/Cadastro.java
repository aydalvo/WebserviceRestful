package br.com.webservicerestful.modelo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * CidadeRestful - br.com.webservice.model - Cadastro.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 11/09/2014 11:06:40
 * @version 1.0
 *
 */

@XmlRootElement
@XmlType(name = "Cadastro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper(name="cidades")
	@XmlElement(name="cidade")
	private List<Cidade> cidades;

	/**
	 * @return the cidades
	 */
	public List<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * @param cidades the cidades to set
	 */
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
