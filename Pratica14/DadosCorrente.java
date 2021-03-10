import java.util.ArrayList;

public class DadosCorrente {
	private ArrayList<Corrente> contas_correntes = new ArrayList<Corrente>();
	
	public void cadastrar(Corrente c){
		this.contas_correntes.add(c);
	}//cadastrar
	
	public Corrente buscar(int nro){
		Corrente c = null;
		for(Corrente objeto: this.contas_correntes){
			if(objeto.getNroConta()==nro){
				c = objeto;
				break;
			}//if
		}//for
		return c;
	}//buscar

	public boolean excluir(int nro){
		Corrente c = this.buscar(nro);
		if(c!=null){
			this.contas_correntes.remove(c);
			return true;
		}//if
		else
			return false;
	}//excluir
	
	public void mostrarDados(Corrente c) {
		System.out.println("Num. da Conta: "+c.getNroConta());
		System.out.println("Agência Cadastrada: "+c.getAgencia());
		System.out.println("Data de Abertura da Conta: "+c.getDataAbertura());
		System.out.println("Saldo da Conta: "+c.getSaldo());
		System.out.println("Situação da Conta: "+c.getSituacao());
		System.out.println("Categoria da Conta: "+c.getCategoria());
		System.out.println("Limite Cheque Especial: "+c.getLimChequeEsp());
	}//mostrar dados
	
	public void listar(){
		for(Corrente objeto: this.contas_correntes){
			mostrarDados(objeto);
			System.out.println();
		}//for
	}//listar
	
}//class
