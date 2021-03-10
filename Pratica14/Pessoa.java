import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	private Endereco ender;
	private String estCivil;
	private Calendar dataNasc = Calendar.getInstance();
	
	public Pessoa(String cpf, String nome, Endereco ender, String estCivil, String dataNasc) {
		setCPF(cpf);
		setNome(nome);
		setEnder(ender);
		setEstCivil(estCivil);
		setDataNasc(dataNasc);
	}
	
	public String getCPF() {
		return cpf;
	}
	public boolean setCPF(String cpf) {
		ValidaCPF teste = new ValidaCPF();
		if(teste.isCPF(cpf)==true) {
			this.cpf = cpf;
			return true;
		}
		else
			return false;
	}
	public String getNome() {
		return nome;
	}
	public boolean setNome(String nome) {
		if(nome.length()>0) {
			this.nome = nome;
			return true;
		}
		else {
			return false;	
		}
	}
	public Endereco getEnder() {
		return ender;
	}
	public void setEnder(Endereco ender) {
		this.ender = ender;
	}
	public String getEstCivil() {
		return estCivil;
	}
	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}
	public String getDataNasc() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(dataNasc.getTime());
	}
	public void setDataNasc(String data) {
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataNasc.setTime(form.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}