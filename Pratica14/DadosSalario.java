import java.util.ArrayList;

public class DadosSalario {
	private ArrayList<Salario> contas_salarios = new ArrayList<Salario>();
	
	public void cadastrar(Salario c){
		this.contas_salarios.add(c);
	}//cadastrar
	
	public Salario buscar(int nro){
		Salario c = null;
		for(Salario objeto: this.contas_salarios){
			if(objeto.getNroConta()==nro){
				c = objeto;
				break;
			}//if
		}//for
		return c;
	}//buscar
	
	public boolean excluir(int nro){
		Salario c = this.buscar(nro);
		if(c!=null){
			this.contas_salarios.remove(c);
			return true;
		}//if
		else
			return false;
	}//excluir
	
	public void mostrarDados(Salario c) {
		System.out.println("Num. da Conta: "+c.getNroConta());
		System.out.println("Agência Cadastrada: "+c.getAgencia());
		System.out.println("Data de Abertura da Conta: "+c.getDataAbertura());
		System.out.println("Saldo da Conta: "+c.getSaldo());
		System.out.println("Situação da Conta: "+c.getSituacao());
		System.out.println("Saldo Minimo: "+c.getSaldoMin());
	}//mostrar dados
	
	public void listar(){
		for(Salario objeto: this.contas_salarios){
			mostrarDados(objeto);
			System.out.println();
		}//for
	}//listar
	
}//class
