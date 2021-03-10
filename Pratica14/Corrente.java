
public class Corrente extends Conta{
	private double limChequeEsp;
	private double taxaAdm;
	private static double tarifaS;
	private static double tarifaP;
	private char categoria; //S p/ standart e P p/ premium
	
	public Corrente(char situacao, String senha, String dataAbert, char categoria,
			Agencia agencia, Cliente titular) {
		super(senha,situacao,0,dataAbert,agencia,titular); //o saldo será sempre setado em 0 quando a conta for criada
		setLimChequeEsp(0);
		setTaxaAdm(0);
		setCategoria(categoria);
	}
	public Corrente(char situacao, String senha, String dataAbert, char categoria,
			Agencia agencia, Cliente titular, double limite, double taxa) {
		super(senha,situacao,0,dataAbert,agencia,titular);
		setLimChequeEsp(limite);
		setTaxaAdm(taxa);
		setCategoria(categoria);
	}
	public Corrente(double limChequeEsp, double taxaAdm, char categoria) {
		super();
		setLimChequeEsp(limChequeEsp);
		setTaxaAdm(taxaAdm);
		setCategoria(categoria);
	}
	
	public void setTarifa(double tarifa) {
		if(getCategoria()=='S')
			Corrente.tarifaS = tarifa;
		else 
			Corrente.tarifaP = tarifa;
	}
	
	public double calculaTarifa() {
		if(getCategoria()=='S')
			return tarifaS;
		else 
			return tarifaP;
	}
	public char getCategoria() {
		return categoria;
	}
	public void setCategoria(char categoria) {
		if(categoria=='S' || categoria=='P')
			this.categoria = categoria;
		else
			this.categoria = 'S';
	}
	public double getLimChequeEsp() {
		return limChequeEsp;
	}
	public boolean setLimChequeEsp(double limChequeEsp) {
		if(limChequeEsp>0) {
			this.limChequeEsp = limChequeEsp;
			return true;
		}else {
			return false;
		}
	}
	public double getTaxaAdm() {
		return taxaAdm;
	}
	public boolean setTaxaAdm(double taxaAdm) {
		if(taxaAdm>0) {
			this.taxaAdm = taxaAdm;
			return true;
		}else {
			return false;
		}
	}
}
