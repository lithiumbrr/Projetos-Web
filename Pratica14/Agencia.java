
public class Agencia {
	private int cod;
	private String nome;
	private Endereco ender;
	private Gerente gerente;
	
	public Agencia(int cod, String nome, Endereco ender) {
		setCod(cod);
		setNome(nome);
		setEnder(ender);
	}
	
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEnder() {
		return ender;
	}
	public void setEnder(Endereco ender) {
		this.ender = ender;
	}
}
