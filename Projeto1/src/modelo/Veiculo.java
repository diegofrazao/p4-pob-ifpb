package modelo;

import java.util.ArrayList;

public class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private ArrayList<Aluguel> aluguel = new ArrayList<Aluguel>();
		
	
	// CONSTRUTOR
	public Veiculo (String placa, String marca, String modelo, int ano) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	//GET & SET
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}	
	public ArrayList<Aluguel> getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		aluguel.setVeiculo(this);
		this.aluguel.add(aluguel);
	}

	@Override
	public String toString() {
		return "Placa: " + placa 
				+ "\nMarca: " + marca 
				+ "\nModelo: " + modelo 
				+ "\nAno: " + ano;
	}	
	
}
