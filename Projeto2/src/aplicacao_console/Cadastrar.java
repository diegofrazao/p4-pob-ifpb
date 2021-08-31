package aplicacao_console;

import fachada.Fachada;

public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		cadastrar();
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}

	public void cadastrar() {
		
		System.out.println("** Cadastrando clientes **");
		try {
			Fachada.cadastrarCliente("diego","end1");
			Fachada.cadastrarCliente("frazao","end2");
			Fachada.cadastrarCliente("fausto","end3");
			Fachada.cadastrarCliente("celso","end4");
			Fachada.cadastrarCliente("lucas","end5");
			Fachada.cadastrarCliente("anderson","end6");
			Fachada.cadastrarCliente("tulio","end7");
			Fachada.cadastrarCliente("mateus","end8");
			Fachada.cadastrarCliente("tomas","end9");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("** Fim de cadastro de clientes **");
		
		System.out.println("\n** Cadastrando veículos **");
		try {
			Fachada.cadastrarVeiculo("placa1","fiat",2001);
			Fachada.cadastrarVeiculo("placa2","fiat",2002);
			Fachada.cadastrarVeiculo("placa3","fiat",2003);
			Fachada.cadastrarVeiculo("placa4","honda",2004);
			Fachada.cadastrarVeiculo("placa5","honda",2005);
			Fachada.cadastrarVeiculo("placa6","citroen",2006);
			Fachada.cadastrarVeiculo("placa7","citroen",2007);
			Fachada.cadastrarVeiculo("placa8","mercedes",2008);
			Fachada.cadastrarVeiculo("placa9","chevrolet",2009);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("** Fim de cadastro de veículos **");
		
		System.out.println("\n** Cadastrando aluguéis **");
		try {
			Fachada.cadastrarAluguel("diego", "placa1", 500);
			Fachada.cadastrarAluguel("diego", "placa2", 500);
			Fachada.cadastrarAluguel("diego", "placa3", 500);
			Fachada.cadastrarAluguel("frazao", "placa4", 500);
			Fachada.cadastrarAluguel("frazao", "placa5", 300);
			Fachada.cadastrarAluguel("fausto", "placa6", 300);
			Fachada.cadastrarAluguel("anderson", "placa7", 500);
			Fachada.cadastrarAluguel("tomas", "placa8", 50);
			Fachada.cadastrarAluguel("tulio", "placa9", 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("** Fim de cadastro de aluguéis **");
	}
	
	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


