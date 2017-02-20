package hello.model;

public class Pais {

	private String nome;
	private int populacao;
	private String capital;
	private Moeda moeda;
	
	public Pais() {
	
	}

	public Pais(String nome, int populacao, String capital, Moeda moeda) {
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
