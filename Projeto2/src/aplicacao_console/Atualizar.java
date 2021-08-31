package aplicacao_console;

import fachada.Fachada;

public class Atualizar {	
	public Atualizar() {
		Fachada.inicializar();
		atualizar();
		Fachada.finalizar();
		System.out.println("Fim de programa");
	}
	
	private void atualizar() {
		try {
			System.out.println(Fachada.alterarCliente("diego","diiego"));
			System.out.println(Fachada.alterarCliente("frazao","fraazao"));
			System.out.println(Fachada.alterarCliente("fausto","faausto"));
			System.out.println(Fachada.alterarVeiculo("placa1","Honda Civic"));
			System.out.println(Fachada.alterarVeiculo("placa2","Fiat Uno"));
			System.out.println(Fachada.alterarVeiculo("placa3","Chevrolet Classic"));
			System.out.println(Fachada.alterarAluguel("placa1","anderson"));
			System.out.println(Fachada.alterarAluguel("placa2","celso"));
			System.out.println(Fachada.alterarAluguel("placa3","tomas"));
		}catch(Exception e){
			e.printStackTrace();
		}	
		System.out.println(Fachada.listarClientes());
		System.out.println(Fachada.listarVeiculos());
		System.out.println(Fachada.listarAlugueis());
	}


	public static void main(String[] args) {
		new Atualizar();
	}
}