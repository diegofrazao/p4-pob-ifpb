package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluguel {

	private Veiculo veiculo;
	private Cliente cliente;
	private double valorDiaria;
	private LocalDate dataAluguel = LocalDate.now();
	private LocalDate dataDevolucao = LocalDate.now().plusDays(15);
	
	// CONSTRUTOR
	public Aluguel(Cliente cliente, Veiculo veiculo, double valorDiaria) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.valorDiaria = valorDiaria;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}	
	
	public Cliente getCliente() {
		return cliente;
	}
		
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public double getValorDiaria() {
		return valorDiaria;
	}
	
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}	
	
	public void setDataAluguel(LocalDate dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	
	@Override
	public String toString() {
		return "Placa do veículo: " + veiculo.getPlaca()
				+ "\nCliente: " + cliente.getNome()
				+ "\nValor da Diaria: " + valorDiaria
				+ "\nData de aluguel: " + dataAluguel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\nData de devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
