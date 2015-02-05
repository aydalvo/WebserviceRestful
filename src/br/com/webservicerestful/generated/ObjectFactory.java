//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2014.09.10 às 06:38:47 PM BRT 
//


package br.com.webservicerestful.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import br.com.webservicerestful.modelo.Cidade;
import br.com.webservicerestful.modelo.Coordenada;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cidade_QNAME = new QName("", "cidade");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cidade }
     * 
     */
    public Cidade createCidade() {
        return new Cidade();
    }

    /**
     * Create an instance of {@link Coordenada }
     * 
     */
    public Coordenada createCidadeCoordenada() {
        return new Coordenada();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cidade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cidade")
    public JAXBElement<Cidade> createCidade(Cidade value) {
        return new JAXBElement<Cidade>(_Cidade_QNAME, Cidade.class, null, value);
    }
    
}
