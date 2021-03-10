import java.util.ArrayList;

public class DadosAgencia {
	private ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	
	public void cadastrar(Agencia a){
		this.agencias.add(a);
	}
	public void listar(){
		for(Agencia objeto: this.agencias){
			mostrarDados(objeto);
			System.out.println();
		}
	}
	public void mostrarDados(Agencia a) {
		System.out.println("Cod: "+a.getCod());
		System.out.println("Nome: "+a.getNome());
		System.out.println("Gerente: "+a.getGerente());
		DadosEndereco end = new DadosEndereco();
		end.mostrarDados(a.getEnder());
	}
	public Agencia buscar(int cod){
		Agencia a = null;
		for(Agencia objeto: this.agencias){
			if(objeto.getCod()==cod){
				a = objeto;
				break;
			}
		}
		return a;
	}
	public boolean excluir(int Cod){
		Agencia a = this.buscar(Cod);
		if(a!=null){
			this.agencias.remove(a);
			return true;
		}
		else
			return false;
	}
}
