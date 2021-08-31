package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.eclipse.persistence.nosql.annotations.NoSql;
import org.eclipse.persistence.nosql.annotations.DataFormatType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Veiculo {
	
	@Id		
	@GeneratedValue
	@Column(name="_id")
	private String id;
	
	private String placa;
	private String modelo;
	private int ano;
	
	@OneToMany (mappedBy="veiculo",
				cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
				orphanRemoval=true,
				fetch=FetchType.LAZY)
	private List<Aluguel> aluguel = new ArrayList<Aluguel>();
		
	// CONSTRUTOR
	public Veiculo () {}
	
	public Veiculo (String placa, String modelo, int ano) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
	}

	//GET & SET
	public String getId() {
		return id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
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
	public List<Aluguel> getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		aluguel.setVeiculo(this);
		this.aluguel.add(aluguel);
	}

	@Override
	public String toString() {
		return "Veiculo "+ id
				+ ", Placa: " + placa
				+ ", Modelo: " + modelo 
				+ ", Ano: " + ano + "\n";
	}	
	
}
