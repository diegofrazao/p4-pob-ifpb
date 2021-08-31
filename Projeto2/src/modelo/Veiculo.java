package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vei20161370002")
public class Veiculo {
	
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String placa;
	private String modelo;
	private int ano;
	@OneToMany (mappedBy="veiculo", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Aluguel> aluguel = new ArrayList<Aluguel>();
		
	
	// CONSTRUTOR
	public Veiculo () {}
	
	public Veiculo (String placa, String modelo, int ano) {
		this.placa = placa;
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
