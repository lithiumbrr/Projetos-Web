import java.util.ArrayList;

public class DadosTransacoes {
	private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
	
	public void cadastrar(Transacao c){
		this.transacoes.add(c);
	}//cadastrar
	
	public Transacao buscar(int id){
		Transacao c = null;
		for(Transacao objeto: this.transacoes){
			if(objeto.getId()==id){
				c = objeto;
				break;
			}//if
		}//for
		return c;
	}//buscar
	
	public boolean excluir(int id){
		Transacao c = this.buscar(id);
		if(c!=null){
			this.transacoes.remove(c);
			return true;
		}//if
		else
			return false;
	}//excluir
	
	public void mostrarDados(Transacao c) {
		System.out.println("Data da Transação: "+c.getData());
		System.out.println("Conta da Transação: "+c.getConta());
		System.out.println("ID da Transação: "+c.getId());
		System.out.println("Valor da Transação: "+c.getValor());
	}//mostrar dados
	
	public void listar(){
		for(Transacao objeto: this.transacoes){
			mostrarDados(objeto);
			System.out.println();
		}//for
	}//listar
	
}//class
