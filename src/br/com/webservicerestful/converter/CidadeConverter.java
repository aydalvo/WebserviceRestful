package br.com.webservicerestful.converter;

import java.io.OutputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import br.com.webservicerestful.generated.ObjectFactory;
import br.com.webservicerestful.modelo.Cadastro;
import br.com.webservicerestful.modelo.Cidade;

/**
 * 
 * WebserviceRestful - br.com.webservicerestful.converter - CidadeConverter.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 11/09/2014 00:19:02
 * @version 1.0
 *
 */
public class CidadeConverter {
	
	/**
	 * 
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 11/09/2014 00:22:40
	 * @version 1.0
	 * @param xml
	 * @return
	 * @throws JAXBException
	 *
	 */
	@SuppressWarnings("unchecked")
	public static Cidade xmlToClass(String xml) throws JAXBException {
		
		StringBuffer xmlStr = new StringBuffer(xml);
		StringReader reader = new StringReader( xmlStr.toString() );
		StreamSource source = new StreamSource( reader );
		JAXBContext context = JAXBContext.newInstance("br.com.webservice.generated");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<Cidade> elemento = (JAXBElement<Cidade>) unmarshaller.unmarshal( source );
		Cidade city = elemento.getValue();
		
		return city;
	}
	
	/**
	 * 
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 11/09/2014 10:54:24
	 * @version 1.0
	 * @param xml
	 * @throws JAXBException
	 *
	 */
	public static List<Cidade> xmlTo(String xml) throws JAXBException {
		
		System.out.println("Conteúdo do xml: " + xml);
		StringBuffer xmlStr = new StringBuffer(xml);
		StringReader reader = new StringReader( xmlStr.toString() );
		StreamSource source = new StreamSource( reader );
		JAXBContext context = JAXBContext.newInstance(Cadastro.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Cadastro cadastro = (Cadastro) unmarshaller.unmarshal(source);
		
		System.out.println(cadastro.getCidades().size());
		
		return cadastro.getCidades();
		
	}
	
	/**
	 * 
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 11/09/2014 00:37:45
	 * @version 1.0
	 * @param cidade
	 * @return
	 * @throws JAXBException
	 *
	 */
	public static JAXBElement<Cidade> classToXml(Cidade cidade) throws JAXBException {
		//TODO: Testar isso depois.
		
		JAXBContext context = JAXBContext.newInstance("br.com.webservice.generated");
		Marshaller marshaller = context.createMarshaller();
		JAXBElement<Cidade> cidadeJAXBElement = new ObjectFactory().createCidade(cidade);
		OutputStream os = null;
		marshaller.marshal(cidadeJAXBElement, os);
		
		return cidadeJAXBElement;
		
	}

	/**
	 *
	 * Método responsável por 
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 11/09/2014 00:19:02
	 * @version 1.0
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
