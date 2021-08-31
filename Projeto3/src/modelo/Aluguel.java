package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Aluguel {

	@Id		
	@GeneratedValue
	@Column(name="_id")
	private String id;
	
	@ManyToOne
	private Veiculo veiculo;
	@ManyToOne
	private Cliente cliente;
	
	private double valorDiaria;
	private String dataAluguel;
	private String dataDevolucao;
	
	@Version
	private int versao;

	// CONSTRUTOR
	public Aluguel() {}
	
	public Aluguel(Cliente cliente, Veiculo veiculo, double valorDiaria, String dataAluguelstr, String dataDevolucaostr) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.valorDiaria = valorDiaria;
		this.dataAluguel = dataAluguelstr;
		this.dataDevolucao = dataDevolucaostr;
	}

	//GET & SET
	public String getId() {
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

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}	

	public void setDataAluguel(String dataAluguel) {
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
				+ ", Data de aluguel: " + dataAluguel
				+ ", Data de devolução: " + dataDevolucao
				+ ", Versão: " + versao + "\n";
	}
}
