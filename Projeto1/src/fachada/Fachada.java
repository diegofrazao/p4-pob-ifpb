package fachada;

import java.util.List;
import dao.DAO;
import dao.DAOAluguel;
import dao.DAOCliente;
import dao.DAOVeiculo;
import modelo.Aluguel;
import modelo.Cliente;
import modelo.Veiculo;

public class Fachada {
	private static DAOCliente daocliente = new DAOCliente();
	private static DAOVeiculo daoveiculo = new DAOVeiculo();
	private static DAOAluguel daoaluguel = new DAOAluguel(); 

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
// ===================== CLIENTES ========================= //
	
	public static Cliente cadastrarCliente(String cpf, String nome, String endereco, int idade) throws Exception{
		DAO.begin();	
		Cliente cliente = daocliente.read(cpf); // PROCURA O CLIENTE NO BANCO DE DADOS
		if(cliente != null) // VERIFICA SE O CLIENTE JÁ EXISTE
			throw new Exception("Cliente já cadastrado no sistema: " + nome);

		cliente = new Cliente(cpf, nome, endereco, idade);
		daocliente.create(cliente);	// CADASTRA O CLIENTE NO BANCO DE DADOS
		DAO.commit();
		return cliente;
	}	
	
	
	public static void excluirCliente(String cpf) throws Exception{
		DAO.begin();
		
		Cliente cliente = daocliente.read(cpf);
		if(cliente == null) { // VERIFICA SE O CLIENTE EXISTE
			DAO.rollback();
			throw new Exception("Cliente ainda não cadastrado no sistema.");
		}
				
		Aluguel aluguel = daoaluguel.read(cpf);
		if(aluguel!=null) // VERIFICA SE O CLIENTE TEM ALUGUEL CADASTRADO
			daoaluguel.delete(aluguel); // SE TIVER ALUGUEL CADASTRADO, EXCLUI
		daocliente.delete(cliente); // EXCLUI O CLIENTE
		DAO.commit();
	}
	
	public static String listarClientes(){ // IMPRIME A LISTA DE CLIENTES
		List<Cliente> clientes = daocliente.readAll();
		String lista = "";
		if (clientes.isEmpty())
			lista += "\n** Lista de clientes vazia. **\n";
		else {
			for (Cliente cl : clientes)
				lista += "\n" + cl + "\n";
		}
		return lista;
	}
	
	public static Cliente consultarPessoasPorCpf(String caracteres) {
		Cliente cliente = daocliente.read(caracteres);
		return cliente;
	}
	
// =========================== VEICULOS ======================= //
	
	public static Veiculo cadastrarVeiculo(String placa, String marca, String modelo, int ano) throws  Exception{
		DAO.begin();	
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo != null) { // VERIFICA SE O VEICULO JÁ EXISTE
			DAO.rollback();
			throw new Exception("Veículo já cadastrado no sistema: " + placa);
		}
		veiculo = new Veiculo(placa, marca, modelo, ano);
		daoveiculo.create(veiculo);	// CADASTRA O VEÍCULO NO BANCO DE DADOS
		DAO.commit();
		return veiculo;
	}
	
	public static void excluirVeiculo(String placa) throws  Exception{
		DAO.begin();	
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo == null)
			throw new Exception("Veiculo não cadastrado no sistema.");
		Aluguel aluguel = daoaluguel.read(placa);
		if(aluguel!=null)
			daoaluguel.delete(aluguel);
		daoveiculo.delete(veiculo);
		DAO.commit();			
	}	
	
	public static String listarVeiculos(){
		List<Veiculo> veiculos = daoveiculo.readAll();
		String lista = "";
		if (veiculos.isEmpty())
			lista += "\n** Lista de veículos vazia. **\n";
		else 
			for (Veiculo vl : veiculos)
				lista += "\n" + vl + "\n";
		return lista;
	}

	public static void consultarDisponibilidadeVeiculo(String placa) throws Exception{
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo == null) 
			throw new Exception("O veiculo não existe.");
		else
			if(daoaluguel.read(placa) != null)
				throw new Exception("O veiculo está indisponível para aluguel.");
		System.out.println("Veículo disponível para aluguel.");
	}
	
	public static Veiculo consultarVeiculo(String placa) {
		Veiculo veiculo = daoveiculo.read(placa);	
		return veiculo;
	}
	
// ======================= ALUGUEL ========================== //
	
	public static Aluguel cadastrarAluguel(String cpf, String placa, double valorDiaria) throws  Exception{
		DAO.begin();	
		Cliente cl = daocliente.read(cpf);
		System.out.println("\n\n\tLeitura do cliente");
		System.out.println(cl);
		if(cl==null)
			throw new Exception("Cliente não cadastrado.");
		Veiculo vl = daoveiculo.read(placa);
		System.out.println("\n\n\tLeitura do veiculo");
		System.out.println(vl);		
		if(vl==null)
			throw new Exception("Veículo não cadastrado.");	
		
		Aluguel al = daoaluguel.read(placa);
		System.out.println("\n\n\tLeitura do aluguel");
		System.out.println(al);
		if(al != null) {
			DAO.rollback();
			throw new Exception("** Veiculo indiponivel para aluguel **\n" + vl 
					+ "\nData de devolução: " + al.getDataDevolucao());
		}
		
		al = new Aluguel(cl, vl, valorDiaria);
		System.out.println("\n\n\tCadastro do aluguel");
		System.out.println(al);
		cl.setAluguel(al);
		vl.setAluguel(al);
		daocliente.update(cl);
		daoveiculo.update(vl);
		daoaluguel.create(al);
		DAO.commit();
		return al;
	}
	
	public static void excluirAluguel(String placa) throws  Exception{
		DAO.begin();
		Aluguel aluguel = daoaluguel.read(placa);
		if(aluguel == null)
			throw new Exception("Aluguel não cadastrado no sistema !!!");
				
		daoaluguel.delete(aluguel);
		DAO.commit();
	}
	
	public static void trocarTitular(String novotitular) {
		DAO.begin();
		DAO.commit();
	}
	
	public static String listarAlugueis(){
		List<Aluguel> alugueis = daoaluguel.readAll();
		String lista = "";
		if (alugueis.isEmpty())
			lista += "\n** Lista de aluguéis vazia. **\n";
		else
		for (Aluguel al : alugueis)
			lista += "\n" + al + "\n";
		lista += "\n";
		return lista;
	}
	
	// ===== Consultas ===============
	
	public static String consulta1(String placa) {
		List<Aluguel> result = daoaluguel.testeDisp(placa);
		String texto = "";
		if (result.isEmpty())  
			texto += "consulta vazia";
		else 
			for(Aluguel x: result)
				texto +=  x + "\n";
		return texto;
	}
	
	public static String consultarClientesNAlugueis(int n) {
		List<Cliente> result = daocliente.consultarNumeroAlugueis(n);

		String texto = "\nCONSULTAR CLIENTES COM MAIS DE "+n+" ALUGUEIS:";
		if (result.isEmpty())
			texto += "\nNenhum cliente com mais de "+n+" aluguéis";
		else
			for(Cliente p: result)
				texto += "\n" + p + "\n";
		return texto;
	}
}