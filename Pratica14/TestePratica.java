import java.util.ArrayList;

public class TestePratica {
	public static void main(String[] args) {
		ArrayList<Endereco> end = new ArrayList<Endereco>();		
		ArrayList<Conta> contas = new ArrayList<Conta>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Funcionario> func = new ArrayList<Funcionario>();
		
		Agencia a1 = new Agencia(1, "ag1", end.get(0));
		Agencia a2 = new Agencia(2, "ag2", end.get(1));
		
		Conta c1 = new Salario('A', "5432","23/03/2020", a2, clientes.get(1), 100);
		
		end.add(new Endereco("José Cambraia", "124", "Centro", "Ibia", "MG"));
		end.add(new Endereco("R. Grande do Norte", "1813", "M Helena", "Udia", "MG"));	
		end.add(new Endereco("Teste", "73", "Tibery", "Udia", "MG"));
		end.add(new Endereco("Teste2", "15", "Martins", "Udia", "MG"));
		end.add(new Endereco("Teste3", "18", "Lagoinha", "Udia", "MG"));
		end.add(new Endereco("Teste4", "21", "Centro", "Udia", "MG"));
		end.add(new Endereco("Teste5", "134", "Fundinho", "ibia", "MG"));
		
		
		func.add(new Funcionario("15597473662", "Nicolli", end.get(6), "solteira", "03/07/2001", 'F', "programadora", "12/04/2019"));
		func.add(new Gerente("23081692067","Lucas",end.get(2),"solteiro","07/10/1984",'M',"Gerente","03/04/2018",true,a1));
		func.add(new Gerente("63349754040","Rafah",end.get(3),"solteira","07/10/1997",'F',"Gerente","08/09/2011",true,a2));
		
		a1.setGerente((Gerente)func.get(1));
		a2.setGerente((Gerente)func.get(2));
		
		clientes.add(new Cliente("15597473662", "Joana", end.get(4), "casada", "ensino superior", "03/07/2001", a1));
		clientes.add(new Cliente("05099976603", "Viviane", end.get(5), "solteira", "ensino superior", "10/03/1997", a2));
		
		contas.add(new Corrente('A', "12345","02/07/2018", a1, clientes.get(0), 1000, 3));
		contas.add(new Poupanca('A', "senha123","10/11/2015", a1, clientes.get(0), 20));
		contas.add(new Salario('A', "5432","23/03/2020", a2, clientes.get(1), 100));
			
		clientes.get(0).setContas(contas.get(0));
		clientes.get(0).setContas(contas.get(1));
		clientes.get(1).setContas(contas.get(2));
			
		contas.get(0).depositar(200, a1, contas.get(0));
		contas.get(2).depositar(312, a2, contas.get(2)); //100 do saldo minimo + 312: 412
					
		//Informações dos clientes
		for(Cliente c: clientes) {
			System.out.println("Nome: "+c.getNome());
			System.out.println("CPF: "+c.getCPF());
			System.out.println("Data de nascimento: "+c.getDataNasc());
			System.out.println("Agência: "+c.getAgencia_cad().getNome()+" (Gerente "+c.getAgencia_cad().getGerente().getNome()+")");
			for(Conta conta: c.getContas()) {
				if(conta instanceof Poupanca)
					System.out.print("Tipo de conta: poupança  |  Nro: "+conta.getNroConta());
				else if(conta instanceof Corrente)
					System.out.print("Tipo de conta: corrente  |  Nro: "+conta.getNroConta());
				else
					System.out.print("Tipo de conta: salário  |  Nro: "+conta.getNroConta());
			
				System.out.println("  |  Saldo: "+conta.getSaldo());
			}
			System.out.println();	
		}
		
		//recibo de uma operação
		System.out.println("\n--Operação de saque--");
		contas.get(0).sacar(50, a1, contas.get(0));
		System.out.println("Conta: "+contas.get(0).getNroConta());
		System.out.println("Valor do saque: "+contas.get(0).getTransacao(1).getValor());
		System.out.println("Saldo final: "+contas.get(0).getSaldo());
		System.out.println("Agência realizada: "+contas.get(0).getTransacao(1).getAgencia().getNome());
		System.out.println("Data: "+contas.get(0).getTransacao(1).getData());
		System.out.println("ID Transação: "+contas.get(0).getTransacao(0).getId());

		//informações dos funcionários
		System.out.println("\n--Calculando salário dos funcionários--");
		for(Funcionario f: func) {
			System.out.println("Nome: "+f.getNome()+"\t|  Cargo: "+f.getCargo()+"\t||  Salário: "+f.calcular_salario());
		}
	}
}
