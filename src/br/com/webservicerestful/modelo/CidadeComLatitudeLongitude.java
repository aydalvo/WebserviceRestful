package br.com.webservicerestful.modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * 
 * WebService2 - br.com.webservice.model - Cidade.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 04/09/2014 12:16:35
 * @version 1.0
 *
 */


@XmlRootElement()
@XmlType(name = "Cidade")
@XmlAccessorType(XmlAccessType.FIELD)
public final class CidadeComLatitudeLongitude extends CidadeAbstrata implements Serializable {
	
	//https://www.youtube.com/watch?v=CYOVWPV6aJw
	//http://www.k19.com.br/artigos/criando-um-webservice-restful-em-java/
	//https://github.com/douglascosta/restful
	
	private static final long serialVersionUID = 1L;
	
	private Latitude latitudeCidade;
	
	private Longitude longitudeCidade;


	/**
	 * @return the latitudeCidade
	 */
	public Latitude getLatitudeCidade() {
		return latitudeCidade;
	}

	/**
	 * @param latitudeCidade the latitudeCidade to set
	 */
	public void setLatitudeCidade(Latitude latitudeCidade) {
		this.latitudeCidade = latitudeCidade;
	}

	/**
	 * @return the longitudeCidade
	 */
	public Longitude getLongitudeCidade() {
		return longitudeCidade;
	}

	/**
	 * @param longitudeCidade the longitudeCidade to set
	 */
	public void setLongitudeCidade(Longitude longitudeCidade) {
		this.longitudeCidade = longitudeCidade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((latitudeCidade == null) ? 0 : latitudeCidade.hashCode());
		result = prime * result
				+ ((longitudeCidade == null) ? 0 : longitudeCidade.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeComLatitudeLongitude other = (CidadeComLatitudeLongitude) obj;
		if (latitudeCidade == null) {
			if (other.latitudeCidade != null)
				return false;
		} else if (!latitudeCidade.equals(other.latitudeCidade))
			return false;
		if (longitudeCidade == null) {
			if (other.longitudeCidade != null)
				return false;
		} else if (!longitudeCidade.equals(other.longitudeCidade))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CidadeComLatitudeLongitude [latitudeCidade=" + latitudeCidade
				+ ", longitudeCidade=" + longitudeCidade + "]";
	}

}
