import java.util.ArrayList;

public class DadosGerente {
	private ArrayList<Gerente> gerentes = new ArrayList<Gerente>();
	
	public void cadastrar(Gerente g){
		this.gerentes.add(g);
	}
	public void listar(){
		for(Gerente objeto: this.gerentes){
			mostrarDados(objeto);
			System.out.println();
		}
	}
	public void mostrarDados(Gerente g) {
		DadosFuncionarios f = new DadosFuncionarios();
		f.mostrarDados(g);
		System.out.println("Bonificação: "+g.getBonificacao());
		System.out.println("Possui curso: "+g.isCurso());
	}
	public Gerente buscar(String CPF){
		Gerente g = null;
		for(Gerente objeto: this.gerentes){
			if(objeto.getCPF().equals(CPF)){
				g = objeto;
				break;
			}
		}
		return g;
	}
	public boolean excluir(String CPF){
		Gerente g = this.buscar(CPF);
		if(g!=null){
			this.gerentes.remove(g);
			return true;
		}
		else
			return false;
		}
}