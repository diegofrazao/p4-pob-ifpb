package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import daojpa.Trigger;

@Entity
@EntityListeners(Trigger.class)
@Cacheable(false)
@Table(name="alu20161370002")
public class Aluguel {

	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Veiculo veiculo;
	@ManyToOne(cascade=CascadeType.ALL)
	private Cliente cliente;
	private double valorDiaria;
	@Transient
	private LocalDate dataDevolucao;
	@Column(columnDefinition="DATE")
	private LocalDate dataAluguel = LocalDate.now();
	@Version
	private int versao;

	// CONSTRUTOR
	public Aluguel() {}

	public Aluguel(Cliente cliente, Veiculo veiculo, double valorDiaria) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.valorDiaria = valorDiaria;
	}

	public int getId() {
		return id;
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

	public int getVersao() {
		return versao;
	}

	@Override
	public String toString() {
		return "Aluguel "+id
				+ ", Placa do veículo: " + veiculo.getPlaca()
				+ ", Cliente: " + cliente.getNome()
				+ ", Valor da Diaria: R$" + valorDiaria
				+ ", Data de aluguel: " + dataAluguel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ ", Data de devolução: " + dataDevolucao
				+ ", Versão: " + versao + "\n";
	}
}
