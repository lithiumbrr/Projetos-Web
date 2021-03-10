import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Funcionario extends Pessoa {
	private char sexo;
	private String cargo;
	protected Calendar dataAdmissao = Calendar.getInstance();
	protected static double salario_base;
	
	public Funcionario(String cpf, String nome, Endereco ender, String estCivil, String dataNasc, 
			char sexo, String cargo, String dataAdmissao) {
		super(cpf, nome, ender, estCivil, dataNasc);
		setSexo(sexo); 
		setCargo(cargo);
		setDataAdmissao(dataAdmissao);
		setSalario_base(1200);
	}

	public char getSexo() {
		return sexo;
	}
	public boolean setSexo(char sexo) {
		if (sexo!='M' || sexo!='F' || sexo!='m' || sexo!='f') 
			return false;
		
		this.sexo = sexo;
		return true;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public static double getSalario_base() {
		return salario_base;
	}
	public static void setSalario_base(double salario_base) {
		if(salario_base<1045)	
			Funcionario.salario_base = 1045;
		else
			Funcionario.salario_base = salario_base;
	}
	public String getDataAdmissao() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		return df.format(dataAdmissao.getTime());
	}
	public void setDataAdmissao(String data) {
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAdmissao.setTime(form.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public double calcular_salario() {
		return salario_base;
	}
}
	