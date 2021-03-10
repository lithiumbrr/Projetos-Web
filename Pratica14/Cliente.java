import java.util.ArrayList;

public class Cliente extends Pessoa{
	private String escolaridade;
	private Agencia agencia_cad;
	private ArrayList<Conta> contas = new ArrayList<Conta>(); //um único cliente pode ter várias contas
	
	public Cliente(String cpf, String nome, Endereco ender, String estCivil, String escolaridade, 
			String dataNasc, Agencia agencia_cad) {
		super(cpf, nome, ender, estCivil, dataNasc);
		setEscolaridade(escolaridade);
		setAgencia_cad(agencia_cad);
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}
	public void setContas(Conta nova_conta) {
		this.contas.add(nova_conta);
	}
	public Agencia getAgencia_cad() {
		return agencia_cad;
	}
	public void setAgencia_cad(Agencia agencia_cad) {
		this.agencia_cad = agencia_cad;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
}
