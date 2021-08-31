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
		
	}


	public static void main(String[] args) {
		new Atualizar();
	}
}