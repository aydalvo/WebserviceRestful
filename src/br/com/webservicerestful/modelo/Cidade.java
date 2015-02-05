package br.com.webservicerestful.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
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
@Entity
public class Cidade implements Serializable {
	
	//https://www.youtube.com/watch?v=CYOVWPV6aJw
	//http://www.k19.com.br/artigos/criando-um-webservice-restful-em-java/
	//https://github.com/douglascosta/restful
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String codigo;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_coordenada")
	private Coordenada coordenada;
	
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

	/**
	 * @return the coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}

	/**
	 * @param coordenada the coordenada to set
	 */
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((coordenada == null) ? 0 : coordenada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (coordenada == null) {
			if (other.coordenada != null)
				return false;
		} else if (!coordenada.equals(other.coordenada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CidadeComCoordenada [id=" + id + ", codigo=" + codigo
				+ ", coordenada=" + coordenada + "]";
	}
	
	public void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("webservice");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		for (int i=0;i<10;i++) {
			Coordenada coordenada = new Coordenada();
			String id = (i+1)+"";
			coordenada = em.getReference(Coordenada.class, Long.parseLong(id));
			
			Cidade cidade = new Cidade();
			cidade.setCodigo(id);
			cidade.setCoordenada(coordenada);
			
			em.persist(cidade);
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
}
