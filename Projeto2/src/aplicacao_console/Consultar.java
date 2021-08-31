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
		System.out.println(Fachada.consultarClientes("d"));
		System.out.println(Fachada.consultarVeiculos("1"));
		System.out.println(Fachada.consultarAlugueis("7"));
		System.out.println(Fachada.consultarClienteNAlugueis(3));
		System.out.println(Fachada.consultarClienteNAlugueis(2));
		System.out.println(Fachada.consulta1("frazao", ""));
		System.out.println(Fachada.consulta1("", "honda"));
	}

	public static void main(String[] args) {
		new Consultar();
	}
}
