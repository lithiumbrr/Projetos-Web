import java.util.ArrayList;

public class DadosEndereco {
	private ArrayList<Endereco> enders = new ArrayList<Endereco>();
	
	public void cadastrar(Endereco e){
		this.enders.add(e);
	}
	public void listar(){
		for(Endereco objeto: this.enders){
			mostrarDados(objeto);
			System.out.println();
		}
	}
	public void mostrarDados(Endereco e) {
		System.out.print("Rua "+e.getRua()+"\tNum "+e.getNum());
		System.out.println("\tBairro "+e.getBairro());
		System.out.println(e.getCidade()+" - "+e.getEstado());		
	}
	public Endereco buscar(int ID){
		Endereco e = null;
		for(Endereco objeto: this.enders){
			if(objeto.getID()==ID){
				e = objeto;
				break;
			}
		}
		return e;
	}
	public boolean excluir(int ID){
		Endereco e = this.buscar(ID);
		if(e!=null){
			this.enders.remove(e);
			return true;
		}
		else
			return false;
	}
}
