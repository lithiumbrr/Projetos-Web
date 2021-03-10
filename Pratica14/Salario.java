
public class Salario extends Conta{
	private double saldoMin;
	public Salario(char situacao, String senha, double saldo, String dataAbert, 
					Agencia agencia, Cliente titular) {
		super(senha,situacao,saldo,dataAbert,agencia,titular);
		setSaldoMin(0);
	}
	public Salario(char situacao, String senha, String dataAbert, Agencia agencia, Cliente titular, double saldoMin) {
		super(senha,situacao,saldoMin,dataAbert,agencia,titular); //o saldo quando a conta for criada será o saldoMin
		setSaldoMin(saldoMin);
	}	
	public Salario(double saldoMin) {
		super();
		setSaldoMin(saldoMin);
	}
	public boolean setSaldo(double saldo) {		
		if(saldo>=saldoMin) {  //para setar um saldo ele deverá ser maior que o saldo minimo
			super.setSaldo(saldo);
			return true;
		}else {
			return false;
		}
	}	
	public boolean sacar(double saque) {
		if(saque>saldo || saque<=0 || saldoMin<(saldo-saque)){
			return false;
		}else {
			setSaldo(saldo-saque);
			return true;
		}
	}
	public boolean transferir(double valor) {
		if(valor<=0 || saldo<valor) {
			return false;
		}else {
			setSaldo(saldo-=valor);
			return true;
		}
	}	
	public double getSaldoMin() {
		return saldoMin;
	}
	public boolean setSaldoMin(double saldoMin) {
		if(saldoMin<0) {
			return false;
		}else {
			this.saldoMin = saldoMin;
			return true;
		}
	}
	public double calculaTarifa() {
		return super.getSaldo()*0.1/100;
	}	
}
