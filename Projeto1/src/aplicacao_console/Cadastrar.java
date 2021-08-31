package aplicacao_console;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Veiculo;

public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		cadastrar();
		Fachada.finalizar();
		System.out.println("Fim do programa");
	}

	public void cadastrar() {
//		Cliente c1=null;
//		Cliente c2=null;
//		Cliente c3=null;
//		Cliente c4=null;
//		Cliente c5=null;
//		Cliente c6=null;
//		Cliente c7=null;
//		Cliente c8=null;
//		Cliente c9=null;
//		Veiculo v1=null;
//		Veiculo v2=null;
//		Veiculo v3=null;
//		Veiculo v4=null;
//		Veiculo v5=null;
//		Veiculo v6=null;
//		Veiculo v7=null;
//		Veiculo v8=null;
//		Veiculo v9=null;
//		
//		System.out.println("** Cadastrando clientes **");
//		
//		try {
//			c1=Fachada.cadastrarCliente("123","teste1","end1",21);
//			c2=Fachada.cadastrarCliente("456","teste2","end2",10);
//			c3=Fachada.cadastrarCliente("789","teste3","end3",5);
//			c4=Fachada.cadastrarCliente("987","teste4","end4",76);
//			c5=Fachada.cadastrarCliente("654","teste5","end5",32);
//			c6=Fachada.cadastrarCliente("321","teste6","end6",87);
//			Fachada.cadastrarCliente("111","teste7","end7",25);
//			Fachada.cadastrarCliente("222","teste8","end8",15);
//			Fachada.cadastrarCliente("333","teste9","end9",62);
//			Fachada.cadastrarCliente("444","teste10","end10",91);
//			c7=Fachada.cadastrarCliente("555","teste11","end11",47);
//			c8=Fachada.cadastrarCliente("666","teste12","end12",38);
//			c9=Fachada.cadastrarCliente("777","teste13","end13",56);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("** Fim de cadastro de clientes");
//		System.out.println("\n** Cadastrando veículos");
//		try {
//			v1=Fachada.cadastrarVeiculo("placa1","marca1","modelo1",2001);
//			v2=Fachada.cadastrarVeiculo("placa2","marca2","modelo2",2002);
//			v3=Fachada.cadastrarVeiculo("placa3","marca3","modelo3",2003);
//			v4=Fachada.cadastrarVeiculo("placa4","marca4","modelo4",2004);
//			v5=Fachada.cadastrarVeiculo("placa5","marca5","modelo5",2005);
//			v6=Fachada.cadastrarVeiculo("placa6","marca6","modelo6",2006);
//			v7=Fachada.cadastrarVeiculo("placa7","marca7","modelo7",2007);
//			v8=Fachada.cadastrarVeiculo("placa8","marca8","modelo8",2008);
//			v9=Fachada.cadastrarVeiculo("placa9","marca9","modelo9",2009);
//			Fachada.cadastrarVeiculo("placa10","marca10","modelo10",2010);
//			Fachada.cadastrarVeiculo("placa11","marca11","modelo11",2011);
//			Fachada.cadastrarVeiculo("placa12","marca12","modelo120",2012);
//			Fachada.cadastrarVeiculo("placa13","marca13","modelo13",2013);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("** Fim de cadastro de veículos");
//		System.out.println("\n** Cadastrando aluguéis");
		try {
			Fachada.cadastrarAluguel("123", "placa1", 500);
			Fachada.cadastrarAluguel("456", "placa2", 50);
			Fachada.cadastrarAluguel("123", "placa3", 200);
//			Fachada.cadastrarAluguel(c4.getCpf(), v4.getPlaca(), 100);
//			Fachada.cadastrarAluguel(c5.getCpf(), v5.getPlaca(), 150);
//			Fachada.cadastrarAluguel(c6.getCpf(), v6.getPlaca(), 300);
//			Fachada.cadastrarAluguel(c1.getCpf(), v7.getPlaca(), 350);
//			Fachada.cadastrarAluguel(c1.getCpf(), v8.getPlaca(), 400);
//			Fachada.cadastrarAluguel(c2.getCpf(), v9.getPlaca(), 700);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("** Fim de cadastro de aluguéis");
	}
	
	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


