import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transacao {
	private Calendar data = Calendar.getInstance();
	private double valor;
	private int id;
	private Agencia agencia;
	private Conta conta;
	private static int IDCont;
	
	public Transacao(String data, double valor, int id, Agencia agencia, Conta conta) {
		setData(data);
		setValor(valor);
		setId(id);
		setAgencia(agencia);
		setConta(conta);
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public boolean setId(int id) {
		if(id<0) {
			return false;
		}else {
			this.id = id;
			return true;
		}
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public String getData() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //retorna a data como uma string com esse formato
		return df.format(data.getTime());
	}
	public void setData(String data) {
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //armazena a data nesse formato
		try { 
			this.data.setTime(form.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//S para saque, T para tranferência, D para depósito
	public boolean efetuaTransacao(char tipo, double valor, Agencia agencia, Conta conta) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //a data da transação será setada com a data atual do pc
		Calendar cal = Calendar.getInstance();
		IDCont++;
		setValor(valor);
		setAgencia(agencia);
		setConta(conta);
		setData(df.format(cal.getTime()));
		setId(IDCont);
		
		if(tipo=='S') 
			conta.sacar(valor);
		else if(tipo=='T')
			conta.transferir(valor);
		else if(tipo=='D')
			conta.depositar(valor);
		else return false;
		
		return true;
	}
}