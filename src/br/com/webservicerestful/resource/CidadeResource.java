package br.com.webservicerestful.resource;

import java.util.Collection;

import javax.xml.bind.JAXBException;

import br.com.webservicerestful.modelo.Cidade;
import br.com.webservicerestful.modelo.MensagemRetorno;

/**
 * 
 * 
 * WebService - br.com.webservice.resource - CidadeResource.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 07/09/2014 19:30:36
 * @version 1.0
 *
 */
public interface CidadeResource {

	public abstract Collection<Cidade> listarTodos();

	public abstract Collection<Cidade> listarTodosXml();

	public abstract String calcularDistanciaEmKmEntreDuasCidadesPassandoCodigo(
			String codCidade1, String codCidade2);

	public abstract Collection<Cidade> retornaAsDuasCidadesMaisProximasExistentesNaBase();
	
	/**
	 * 
	 *
	 * Método responsável por cadastrar Cidade utilizando como input de dados uma String contendo um xml.
	 * 
	 * Estrutura esperada no Xml
	 * <cadastro>
     * 		<cidades>
     *    		<cidade>
	 *				<codigo>valor</codigo>
	 *				<coordenada>
	 *					<latitude>valor</latitude>
	 *					<longitude>valor</longitude>
	 *				</coordenada>
	 *			</cidade>
	 *			<cidade></cidade> -- pode se repetir!
	 *		</cidades>
	 *	</cadastro>
	 *
	 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
	 * @since 11/09/2014 13:41:08
	 * @version 1.0
	 * @param xml
	 * @return
	 * @throws JAXBException
	 *
	 */
	public abstract MensagemRetorno inserirCidade(String xml) throws JAXBException;
	
}