package aplicacao_console;

import fachada.Fachada;

public class Listar {

	public Listar(){
		Fachada.inicializar();
		listar();
		Fachada.finalizar();
		System.out.println("Fim do programa.");
	}
	
	public void listar() {
		System.out.println("==== Clientes ====");
		System.out.println(Fachada.listarClientes());
		System.out.println("==== Veículos ====");
		System.out.println(Fachada.listarVeiculos());
		System.out.println("==== Aluguéis ====");
		System.out.println(Fachada.listarAlugueis());
		System.out.println("Até logo!");
	}

	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}
