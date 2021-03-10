
public class Endereco {
	private String rua;
	private String num; 
	private String cidade; 
	private String bairro; 
	private String estado;
	private int ID;
	private static int IDCont;
	
	public Endereco(String rua, String num, String bairro, String cidade, String estado) {
		setRua(rua);
		setNum(num);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		IDCont++;
		setID(IDCont);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	} 
}
