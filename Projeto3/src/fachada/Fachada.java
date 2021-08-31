package fachada;

import java.time.LocalDate;
import java.util.List;

import daomongodb.*;
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
	
	public static Cliente cadastrarCliente(String nome, String endereco) throws Exception{
		DAO.begin();	
		Cliente cliente = daocliente.read(nome); // PROCURA O CLIENTE NO BANCO DE DADOS
		if(cliente != null) { // VERIFICA SE O CLIENTE JÁ EXISTE
			DAO.rollback();
			throw new Exception("Cliente já cadastrado no sistema: " + nome);
		}
		cliente = new Cliente(nome, endereco);
		daocliente.create(cliente);	// CADASTRA O CLIENTE NO BANCO DE DADOS
		DAO.commit();
		return cliente;
	}	
	
	public static Cliente alterarCliente(String nome, String novonome) throws Exception{
		DAO.begin();
		Cliente cliente = daocliente.read(nome);	//usando  chave primaria
		if (cliente==null) {
			DAO.rollback();
			throw new Exception("nome inexistente:" + nome);
		}
		cliente.setNome(novonome); 			
		cliente=daocliente.update(cliente);     	
		DAO.commit();
		return cliente;
	}
	
	public static void excluirCliente(String nome) throws Exception{
		DAO.begin();
		Cliente cliente = daocliente.read(nome);
		if (cliente == null) { // VERIFICA SE O CLIENTE EXISTE
			DAO.rollback();
			throw new Exception("Cliente ainda não cadastrado no sistema.");
		}				
		daocliente.delete(cliente); // EXCLUI O CLIENTE
		DAO.commit();
	}
	
	public static List<Cliente> listarClientes(){ // IMPRIME A LISTA DE CLIENTES
		return daocliente.readAll();
	}
	
	public static List<Cliente> consultarClientes(String caracteres) {
		return daocliente.consultarClientes(caracteres);
	}
	
// =========================== VEICULOS ======================= //
	
	public static Veiculo cadastrarVeiculo(String placa, String modelo, int ano) throws  Exception{
		DAO.begin();	
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo != null) { // VERIFICA SE O VEICULO JÁ EXISTE
			DAO.rollback();
			throw new Exception("Veículo já cadastrado no sistema: " + placa);
		}
		veiculo = new Veiculo(placa, modelo, ano);
		daoveiculo.create(veiculo);	// CADASTRA O VEÍCULO NO BANCO DE DADOS
		DAO.commit();
		return veiculo;
	}
	
	public static Veiculo alterarVeiculo(String placa, String novomodelo) throws Exception{
		DAO.begin();		
		Veiculo veiculo = daoveiculo.read(placa);	//usando  chave primaria
		if (veiculo==null) {
			DAO.rollback();
			throw new Exception("placa inexistente:" + placa);
		}
		veiculo.setModelo(novomodelo);
		veiculo=daoveiculo.update(veiculo);     	
		DAO.commit();
		return veiculo;
	}
	
	public static void excluirVeiculo(String placa) throws  Exception{
		DAO.begin();	
		Veiculo veiculo = daoveiculo.read(placa);
		if(veiculo == null) {
			DAO.rollback();
			throw new Exception("Veiculo não cadastrado no sistema.");
		}
		daoveiculo.delete(veiculo);
		DAO.commit();			
	}	
	
	public static List<Veiculo> listarVeiculos(){
		return daoveiculo.readAll();
	}
	
	public static List<Veiculo> consultarVeiculos(String placa) {
		return daoveiculo.consultarVeiculos(placa);
	}
	
// ======================= ALUGUEL ========================== //
	
	public static Aluguel cadastrarAluguel(String nome, String placa, double valorDiaria) throws  Exception{
		DAO.begin();	
		Cliente cl = daocliente.read(nome);
		if(cl==null)
			throw new Exception("Cliente não cadastrado.");
		Veiculo vl = daoveiculo.read(placa);
		if(vl==null)
			throw new Exception("Veículo não cadastrado.");	
		
		Aluguel al = new Aluguel(cl, vl, valorDiaria, LocalDate.now().toString(), LocalDate.now().plusDays(15).toString());
		cl.setAluguel(al);
		vl.setAluguel(al);
		daocliente.update(cl);
		daoveiculo.update(vl);
		daoaluguel.create(al);
		DAO.commit();
		return al;
	}
	
	public static void excluirAluguel(String placa) throws Exception{
		DAO.begin();
		Aluguel aluguel = daoaluguel.read(placa);
		if(aluguel == null)
			throw new Exception("Aluguel não cadastrado no sistema !!!");
				
		daoaluguel.delete(aluguel);
		DAO.commit();
	}
	
	public static Aluguel alterarAluguel(String placa, String novotitular) throws Exception {
		DAO.begin();
		Cliente cliente = daocliente.read(novotitular);
		if(cliente == null)
			throw new Exception("Novo titular não encontrado.");
		Aluguel aluguel = daoaluguel.read(placa);
		if(aluguel == null)
			throw new Exception("Aluguel não encontrado.");
		
		aluguel.setCliente(cliente);
		daocliente.update(cliente);
		aluguel=daoaluguel.update(aluguel);
		DAO.commit();
		return aluguel;
	}
	
	public static List<Aluguel> listarAlugueis(){
		return daoaluguel.readAll();
	}
	
	public static List<Aluguel> consultarAlugueis(String placa){
		return daoaluguel.consultarAlugueis(placa);
	}
}