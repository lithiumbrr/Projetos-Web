import java.util.ArrayList;

public class DadosPoupanca {
	private ArrayList<Poupanca> contas_poupancas = new ArrayList<Poupanca>();
	
	public void cadastrar(Poupanca c){
		this.contas_poupancas.add(c);
	}//cadastrar
	
	public Poupanca buscar(int nro){
		Poupanca c = null;
		for(Poupanca objeto: this.contas_poupancas){
			if(objeto.getNroConta()==nro){
				c = objeto;
				break;
			}//if
		}//for
		return c;
	}//buscar
	
	public boolean excluir(int nro){
		Poupanca c = this.buscar(nro);
		if(c!=null){
			this.contas_poupancas.remove(c);
			return true;
		}//if
		else
			return false;
	}//excluir
	
	public void mostrarDados(Poupanca c) {
		System.out.println("Num. da Conta: "+c.getNroConta());
		System.out.println("Agência Cadastrada: "+c.getAgencia());
		System.out.println("Data de Abertura da Conta: "+c.getDataAbertura());
		System.out.println("Saldo da Conta: "+c.getSaldo());
		System.out.println("Situação da Conta: "+c.getSituacao());
		System.out.println("Renda Mensal: "+c.getRendMes());
	}//mostrar dados
	
	public void listar(){
		for(Poupanca objeto: this.contas_poupancas){
			mostrarDados(objeto);
			System.out.println();
		}//for
	}//listar
	
}//class
