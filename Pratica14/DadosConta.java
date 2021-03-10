import java.util.ArrayList;

public class DadosConta {
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void cadastrar(Conta c){
		this.contas.add(c);
	}//cadastrar
	
	public boolean excluir(int nro){
		Conta c = this.buscar(nro);
		if(c!=null){
			this.contas.remove(c);
			return true;
		}//if
		else
			return false;
	}//excluir
	
	public Conta buscar(int nro){
		Conta c = null;
		for(Conta objeto: this.contas){
			if(objeto.getNroConta()==nro){
				c = objeto;
				break;
			}//if
		}//for
		return c;
	}//buscar
	
	public void mostrarDados(Conta c) {
		System.out.println("Num. da Conta: "+c.getNroConta());
		System.out.println("Agência Cadastrada: "+c.getAgencia());
		System.out.println("Data de Abertura da Conta: "+c.getDataAbertura());
		System.out.println("Saldo da Conta: "+c.getSaldo());
		System.out.println("Situação da Conta: "+c.getSituacao());
	}//mostrar dados
	
	public void listar(){
		for(Conta objeto: this.contas){
			mostrarDados(objeto);
			System.out.println();
		}//for
	}//listar
	
	
}//class
