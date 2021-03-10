import java.util.ArrayList;

public class DadosFuncionarios {
	private ArrayList<Funcionario> funcs = new ArrayList<Funcionario>();
	
	public void cadastrar(Funcionario f){
		this.funcs.add(f);
	}
	public void listar(){
		for(Funcionario objeto: this.funcs){
			mostrarDados(objeto);
			System.out.println();
		}
	}
	public void mostrarDados(Funcionario f) {
		DadosPessoas p = new DadosPessoas();
		p.mostrarDados(f);
		System.out.println("Cargo: "+f.getCargo());
		System.out.println("Sexo: "+f.getSexo());
		System.out.println("Data de admissão: "+f.getDataAdmissao());
		System.out.println("Salário: "+f.calcular_salario());
	}
	public Funcionario buscar(String CPF){
		Funcionario f = null;
		for(Funcionario objeto: this.funcs){
			if(objeto.getCPF().equals(CPF)){
				f = objeto;
				break;
			}
		}
		return f;
	}
	public boolean excluir(String CPF){
		Funcionario f = this.buscar(CPF);
		if(f!=null){
			this.funcs.remove(f);
			return true;
		}
		else
			return false;
	}
}
