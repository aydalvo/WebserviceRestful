package br.com.webservicerestful.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.JAXBException;

import br.com.webservicerestful.business.CidadeController;
import br.com.webservicerestful.converter.CidadeConverter;
import br.com.webservicerestful.dao.CidadeDAO;
import br.com.webservicerestful.infra.JPAUtil;
import br.com.webservicerestful.modelo.Cidade;
import br.com.webservicerestful.modelo.MensagemRetorno;

/**
 * 
 * 
 * WebService - br.com.webservice.resource - CidadeResourceImpl.java
 *
 * Classe responsável por 
 *
 * @author Aydalvo Nery Neto <aydalvo.nery@gmail.com>
 * @since 07/09/2014 19:30:09
 * @version 1.0
 *
 */

@Path("/cidade")
public class CidadeResourceImpl implements CidadeResource {
	
	//http://192.168.0.7:8080/WebserviceRestful/services/CidadeResourceImpl?wsdl
	//http://localhost:8080/WebserviceRestful/ws/cidade/listarTodosJson
	//http://localhost:8080/WebserviceRestful/ws/cidade/listarTodosXml
	//http://localhost:8080/WebserviceRestful/ws/cidade/calcularDistanciaEmKmEntreDuasCidadesPassandoCodigo
	//http://localhost:8080/WebserviceRestful/ws/cidade/calcularDistanciaEmKmEntreDuasCidadesPassandoCodigo?codCidade1=0&codCidade2=1
	//http://localhost:8080/WebserviceRestful/ws/cidade/retornaAsDuasCidadesMaisProximasExistentesNaBase
	
	CidadeController controller;
	
	public CidadeController getController() {
		return controller.criaInstancia();
	}

	public void setController(CidadeController controller) {
		this.controller = controller;
	}

//	@Override
	@GET
	@Path("/listarTodosJson")
	@Produces("application/json")
	public Collection<Cidade> listarTodos(){
		return new CidadeController().listarTodos();
	}

//	@Override
	@GET
	@Path("/listarTodosXml")
	@Produces("application/xml")
	public List<Cidade> listarTodosXml() {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		CidadeDAO cidadeDAO = new CidadeDAO(em);
		List<Cidade> cidades = cidadeDAO.lista();
		
		return cidades;
	}
	
//	@Override
	@GET
	@Path("/calcularDistanciaEmKmEntreDuasCidadesPassandoCodigo")
	@Produces("application/json")
	public String calcularDistanciaEmKmEntreDuasCidadesPassandoCodigo(@QueryParam(value = "codCidade1") String codCidade1, @QueryParam(value = "codCidade2") String codCidade2) {
		Cidade cidade1 = new CidadeController().buscar(codCidade1);
		
		if (cidade1==null) {
			throw new RuntimeException("Não foi encontrada a cidade referente ao código: "+ codCidade1);
		}
		
		Cidade cidade2 = new CidadeController().buscar(codCidade2);
		if (cidade2==null) {
			throw new RuntimeException("Não foi encontrada a cidade referente ao código: "+ codCidade2);
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("A distancia entre as cidades "); 
		buffer.append(" 'cidade1: "); 
		buffer.append(cidade1.getCodigo()); 
		buffer.append("' e a 'cidade2: "); 
		buffer.append(cidade2.getCodigo()); 
		buffer.append("' em kilometros e: "); 
		
		Double distanciaEmKm = calculaRaizQuadrada(cidade1, cidade2);
		
		buffer.append(distanciaEmKm); 
		
		return buffer.toString();
	}
	
	/**
	 * Cálcula o valor do cateto (a ou b), neste ponto desprezo o sinal (positivo ou negativo)
	 * 
	 * @param primeiroValor
	 * @param segundoValor
	 * @return
	 */
	private Double calculaCateto(String primeiroValor, String segundoValor) {
		return Double.parseDouble(primeiroValor)-Double.parseDouble(segundoValor);
	}
	
	
	/**
	 * Eleva o valor do cateto a segunda potência, tornando o número negativo em positivo.
	 * @param cateto
	 * @return
	 */
	private Double catetoValorAbsoluto(Double cateto) {
		return Math.pow(cateto, Double.parseDouble("2"));
	}
	
	/**
	 * 
	 * Calcula a distância entre dois pontos (a partir da coordenada - latitude e longitude) 
	 * utilizando o teorema de pitágoras.
	 * 
	 * @param catetoA
	 * @param catetoB
	 * @return 
	 */
	private Double calculaRaizQuadrada(Cidade cidade1, Cidade cidade2) {
		Double catetoA = catetoValorAbsoluto(calculaCateto( cidade1.getCoordenada().getLatitude(), cidade2.getCoordenada().getLatitude()));
		
		Double catetoB = catetoValorAbsoluto(calculaCateto( cidade1.getCoordenada().getLongitude(), cidade2.getCoordenada().getLongitude()));
		
		Double somaDosCatetos=catetoA+catetoB;
		
		return Math.sqrt(somaDosCatetos);
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.webservice.resource.CidadeResource#retornaAsDuasCidadesMaisProximasExistentesNaBase()
	 */
//	@Override
	@GET
	@Path("/retornaAsDuasCidadesMaisProximasExistentesNaBase")
	@Produces("application/json")
	public ArrayList<Cidade> retornaAsDuasCidadesMaisProximasExistentesNaBase(){
		ArrayList<Cidade> retorno = new ArrayList<Cidade>();
		
		cidadesProximas(retorno);
		
		return retorno;
	}
	
	/**
	 * Chamada para encontrar as duas cidades mais próximas 
	 * @param retorno
	 */
	private void cidadesProximas(ArrayList<Cidade> retorno) {
		Collection<Cidade> cidades = new CidadeController().listarTodos();
		int pos = 1;
		Double dist = Double.MAX_VALUE;
		for (Cidade itCidade : cidades) {
			dist = percorreListaParaEncontrarMaisProximas(itCidade, cidades, pos, dist, retorno);
			pos++;
		}
	}

	/**
	 * Busca recursiva para obter as duas cidades mais próximas, a partir da latitude e longitude.
	 * @param cidade
	 * @param cidades
	 * @param pos
	 * @param dist
	 * @param retorno
	 * @return
	 */
	private Double percorreListaParaEncontrarMaisProximas(Cidade cidade, Collection<Cidade> cidades, int pos, Double dist, ArrayList<Cidade> retorno) {
		Double dista = Double.MAX_VALUE; 
		if (pos < cidades.size()-1) {
			
			Cidade cidade2 = ( (ArrayList<Cidade>) cidades).get(pos);
			dista = calculaRaizQuadrada(cidade, cidade2);
			
			System.out.println("a distancia eh: "+dist);
			System.out.println("a distancia eh: "+dista);
			
			if (dista<dist) {
				percorreListaParaEncontrarMaisProximas(cidade, cidades, pos+1, dista, retorno);
				retorno.add(cidade);
				retorno.add(cidade2);
			}
			
		} 
		return dista;
	}

//	@Override
	@POST
	@Path("/inserirCidades")
	@Produces("application/xml")
	public MensagemRetorno inserirCidade(String xml) throws JAXBException {
		
		System.out.println("inserirCidade...");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		CidadeDAO cidadeDAO = new CidadeDAO(em);
		
		List<Cidade> cities = CidadeConverter.xmlTo(xml);
		
		for (Cidade city : cities) {
			cidadeDAO.salva(city);
		}
		
		em.getTransaction().commit();
		em.close();
		
		StringBuilder mensagens = new StringBuilder();
		mensagens.append("Inserido com sucesso!");
		mensagens.append("\n");
		mensagens.append("O total de ");
		
		int qtdItem = cities.size();
		if (qtdItem>1) {
			mensagens.append("itens inseridos foram: " + qtdItem);
		} else {
			mensagens.append("item inserido foi: " + qtdItem);
		}
		
		MensagemRetorno mensagemRetorno = new MensagemRetorno();
		mensagemRetorno.setMensagem(mensagens.toString());
		mensagemRetorno.setQuantidade(qtdItem);
		
//		String mensagem = "Cidade inserida com sucesso...";
//		System.out.println(mensagem);
//		
//		System.out.println(mensagens.toString());
		
		return mensagemRetorno;
		
	}

}
