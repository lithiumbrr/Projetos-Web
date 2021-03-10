import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Conta {
	private String senha;
	private int nroConta;
	private static int i=1; //Variável de iteração, criei para setar o nroConta de forma sequencial e automática
	private byte situacao;
	protected double saldo;
	private Calendar dataAbertura = Calendar.getInstance();
	private Agencia agencia;
	private ArrayList<Cliente> titular = new ArrayList<Cliente>(2);
	
	public Conta(String senha, char situacao, double saldo, String dataAbert, 
					Agencia agencia, Cliente titular) {
		setSenha(senha);
		setNroConta(i++); //a cada vez que uma conta é criada, o Nro da conta é setado com o valor do iterador
		setSituacao(situacao);
		setSaldo(saldo);
		setDataAbertura(dataAbert);		
		setAgencia(agencia);
		setTitular(titular);
	}
	public Conta(Agencia agencia) {
		setAgencia(agencia);
		setNroConta(nroConta++);
	}
	public Conta() {
		this.senha = "0000";
		this.situacao = 'N';
		this.saldo = 0.0;
		setNroConta(nroConta++);
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public ArrayList<Cliente> getTitular(){
		return titular;
	}
	public boolean setTitular(Cliente titular) {
		if(this.titular.size()==2)
			return false;
		else {
			this.titular.add(titular);
			return true;
		}
	}
	public String getSenha() {
		return senha;
	}
	public boolean setSenha(String senha) {
		if(senha.length()<4) {
			return false;
		}else {
			this.senha = senha;
			return true;
		}
	}
	public String getSituacao() {
		String sit;
		if(situacao=='1')
			sit = "Ativa";
		else if(situacao=='2')
			sit = "Inativa";
		else
			sit = "Análise";
			
		return sit;
	}
	public boolean setSituacao(char sit) {
		if(sit=='A') 
			this.situacao = 1;
		else if(sit=='I')
			this.situacao = 2;
		else if(sit=='N')
			this.situacao = 3;
		else {
			return false;
		}
		return true;
	}
	public int getNroConta() {
		return nroConta;
	}
	public boolean setNroConta(int nroConta) {
		if(nroConta>=0) {
			this.nroConta = nroConta;
			return true;
		}else {
			return false;
		}
	}
	public double getSaldo() {
		return saldo;
	}
	public boolean setSaldo(double saldo) {
		if(saldo>0) {
			this.saldo = saldo;
			return true;
		}else {
			return false;
		}
	}
	public boolean sacar(double saque) { 
		if(saque>this.saldo || saque<=0){
			return false;
		}else {
			setSaldo(this.saldo-saque);
			return true;
		}
	}
	public boolean depositar(double valor) {
		if(valor<0) {
			return false;
		}else {
			setSaldo(this.saldo+=valor);
			return true;
		}
	}
	public boolean transferir(double valor) {
		if(valor<0 || this.saldo<valor) {
			return false;
		}else {
			setSaldo(this.saldo-=valor);
			return true;
		}
	}
	public String getDataAbertura() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT); //retorna a data como uma string
		return df.format(dataAbertura.getTime());
	}
	public void setDataAbertura(String data) { //recebe uma string e armazena a data sendo do tipo Calendar
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataAbertura.setTime(form.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public abstract double calculaTarifa();
}
