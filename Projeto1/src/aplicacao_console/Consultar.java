package aplicacao_console;

import fachada.Fachada;

public class Consultar {
	
	public Consultar() {
		Fachada.inicializar();
		consultar();
		Fachada.finalizar();
		System.out.println("Fim de programa");
	}
		private void consultar() {
		System.out.println("** Mostrando consultas **");
		System.out.println(Fachada.consulta1("123"));
		System.out.println(Fachada.consultarClientesNAlugueis(1));
	}


	public static void main(String[] args) {
		new Consultar();
	}
}
