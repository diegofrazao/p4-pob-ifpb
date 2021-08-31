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
		System.out.println("** Excluindo clientes **");
		try {
			Fachada.excluirCliente("tomas");
			Fachada.excluirCliente("mateus");
			Fachada.excluirCliente("tulio");
			Fachada.excluirCliente("lucas");
			Fachada.excluirCliente("diego");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("** Fim de exclus�o de clientes**");
		
		System.out.println("\n** Excluindo ve�culos **");
		try {
			Fachada.excluirVeiculo("placa1");
			Fachada.excluirVeiculo("placa3");
			Fachada.excluirVeiculo("placa5");
			Fachada.excluirVeiculo("placa7");
			Fachada.excluirVeiculo("placa9");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("** Fim de cadastro de ve�culos **");
		
		System.out.println("\n** Excluindo alugu�is **");
		try {
			Fachada.excluirAluguel("placa1");
			Fachada.excluirAluguel("placa3");
			Fachada.excluirAluguel("placa5");
			Fachada.excluirAluguel("placa7");
			Fachada.excluirAluguel("placa9");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("** Fim de exclus�o de alugu�is **");
	}

	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}


