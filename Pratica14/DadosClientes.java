import java.util.ArrayList;

public class DadosClientes {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void cadastrar(Cliente c){
		this.clientes.add(c);
	}
	
	public void listar(){
		for(Cliente objeto: this.clientes){
			mostrarDados(objeto);
			System.out.println();
		}
	}
	
	public void mostrarDados(Cliente c) {
		DadosPessoas p = new DadosPessoas();
		p.mostrarDados(c);
		System.out.println("Escolaridade: "+c.getEscolaridade());
		System.out.println("Agência Cadastrada: "+c.getAgencia_cad());
	}
	
	public Cliente buscar(String CPF){
		Cliente c = null;
		for(Cliente objeto: this.clientes){
			if(objeto.getCPF().equals(CPF)){
				c = objeto;
				break;
			}
		}
		return c;
	}
	public boolean excluir(String CPF){
		Cliente c = this.buscar(CPF);
		if(c!=null){
			this.clientes.remove(c);
			return true;
		}
		else
			return false;
	}
}
