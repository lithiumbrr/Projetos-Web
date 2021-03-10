
public class Poupanca extends Conta{
	private double rendMes;
	private static double tarifa;

	public Poupanca(char situacao, String senha, String dataAbert, 
						Agencia agencia, Cliente titular) {
		super(senha,situacao,0,dataAbert,agencia,titular);
		setRendMes(0);
		setTarifa(1.5);
	}
	public Poupanca(char situacao, String senha, String dataAbert, 
						Agencia agencia, Cliente titular, double rendMes){
		super(senha,situacao,0,dataAbert,agencia,titular);
		setRendMes(rendMes);
		setTarifa(1.5);
	}
	
	public Poupanca(double rendMes) {
		super();
		setRendMes(rendMes);
		setTarifa(1.5);
	}
	
	public double calculaTarifa() {
		return tarifa;
	}
	public static void setTarifa(double tarifa) {
		Poupanca.tarifa = tarifa;
	}
	public double getRendMes() {
		return rendMes;
	}

	public boolean setRendMes(double rendMes) {
		if(rendMes<0) {
			return false;
		}else {
			this.rendMes = rendMes;
			return true;
		}
	}	
}
