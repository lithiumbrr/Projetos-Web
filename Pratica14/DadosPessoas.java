import java.util.ArrayList;

public class DadosPessoas {
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public void cadastrar(Pessoa p){
		this.pessoas.add(p);
	}
	public void listar(){
		for(Pessoa objeto: this.pessoas){
			mostrarDados(objeto);
			System.out.println();
		}
	}
	public void mostrarDados(Pessoa p) {
		System.out.println("Nome: "+p.getNome());
		System.out.println("CPF: "+p.getCPF());
		System.out.println("Data de nascimento: "+p.getDataNasc());
		System.out.println("Estado civil: "+p.getEstCivil());
		DadosEndereco end = new DadosEndereco();
		end.mostrarDados(p.getEnder());
	}
	public Pessoa buscar(String CPF){
		Pessoa c = null;
		for(Pessoa objeto: this.pessoas){
			if(objeto.getCPF().equals(CPF)){
				c = objeto;
				break;
			}
		}
		return c;
	}
	public boolean excluir(String CPF){
		Pessoa c = this.buscar(CPF);
		if(c!=null){
			this.pessoas.remove(c);
			return true;
		}
		else
			return false;
	}
}
