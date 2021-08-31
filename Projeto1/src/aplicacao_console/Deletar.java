package aplicacao_console;

import fachada.Fachada;

public class Deletar {

	public Deletar(){
		Fachada.inicializar();
		deletar();
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}
	
	public void deletar () {		
//		System.out.println("** Excluindo clientes **");
//		try {
//			Fachada.excluirCliente("123");
//			Fachada.excluirCliente("456");
//			Fachada.excluirCliente("789");
//			Fachada.excluirCliente("987");
//			Fachada.excluirCliente("654");
//			Fachada.excluirCliente("321");
//			Fachada.excluirCliente("111");
//			Fachada.excluirCliente("222");
//			Fachada.excluirCliente("333");
//			Fachada.excluirCliente("444");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("** Fim de exclusão de clientes");
//		System.out.println("\n** Excluindo veículos");
//		try {
//			Fachada.excluirVeiculo("placa1");
//			Fachada.excluirVeiculo("placa2");
//			Fachada.excluirVeiculo("placa3");
//			Fachada.excluirVeiculo("placa4");
//			Fachada.excluirVeiculo("placa5");
//			Fachada.excluirVeiculo("placa6");
//			Fachada.excluirVeiculo("placa7");
//			Fachada.excluirVeiculo("placa8");
//			Fachada.excluirVeiculo("placa9");
//			Fachada.excluirVeiculo("placa10");
//			Fachada.excluirVeiculo("placa11");
//			Fachada.excluirVeiculo("placa12");
//			Fachada.excluirVeiculo("placa13");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("** Fim de cadastro de veículos");
		System.out.println("\n** Excluindo aluguéis");
		try {
			Fachada.excluirAluguel("placa1");
			Fachada.excluirAluguel("placa2");
			Fachada.excluirAluguel("placa3");
//			Fachada.excluirAluguel("placa4");
//			Fachada.excluirAluguel("placa5");
//			Fachada.excluirAluguel("placa6");
//			Fachada.excluirAluguel("placa7");
//			Fachada.excluirAluguel("placa8");
//			Fachada.excluirAluguel("placa9");
//			Fachada.excluirAluguel("placa10");
//			Fachada.excluirAluguel("placa11");
//			Fachada.excluirAluguel("placa12");
//			Fachada.excluirAluguel("placa13");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("** Fim de exclusão de aluguéis");
	}

	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}


