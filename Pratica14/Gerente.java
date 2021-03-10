import java.util.Calendar;

public class Gerente extends Funcionario{
	private boolean curso;
	private static double bonificacao;
	private Agencia agencia;
	
	public Gerente(String cpf, String nome, Endereco ender, String estCivil, String dataNasc, char sexo, 
			String cargo, String dataAdmissao, boolean curso, Agencia agencia) {
		super(cpf, nome, ender, estCivil, dataNasc, sexo, cargo, dataAdmissao);
		setCurso(curso);
		setAgencia(agencia);
		setBonificacao(200);
	}

	public double getBonificacao() {
		return Gerente.bonificacao;
	}
	public static void setBonificacao(double bonificacao) {
		if(bonificacao<0)
			bonificacao = 0;
		else Gerente.bonificacao = bonificacao;
	}
	public boolean isCurso() {
		return curso;
	}
	public void setCurso(boolean curso) {
		this.curso = curso;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public double calcular_salario() { 
		Calendar cal = Calendar.getInstance(); //pega o ano atual e subtrai pelo ano da admissão
		return salario_base + (bonificacao*(cal.get(Calendar.YEAR) - dataAdmissao.get(Calendar.YEAR)));
	}
}
