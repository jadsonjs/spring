/**
 * 
 */
package hello.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * JAXB Annotated Model Objects
 * 
 * @author Jadson Santos - jadson@info.ufrn.br
 *
 */
@XmlRootElement (name = "pais")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaisXML {

	@XmlElement
	private String nome;
	
	@XmlElement
	private int populacao;
	
	@XmlElement
	private String capital;
	
	@XmlElement
	private Moeda moeda;
	
	
	
	public PaisXML() {
		super();
	}

	public PaisXML(String nome, int populacao, String capital, Moeda moeda) {
		this.nome = nome;
		this.populacao = populacao;
		this.capital = capital;
		this.moeda = moeda;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Moeda getMoeda() {
		return moeda;
	}
	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
}
