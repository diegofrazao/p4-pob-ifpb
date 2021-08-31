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
@Table(name="cli20161370002")
public class Cliente {
	
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String endereco;
	@OneToMany (mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Aluguel> aluguel = new ArrayList<Aluguel>();
	
	
	// CONSTRUTOR
	public Cliente () {}
	
	public Cliente (String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	//GET & SET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Aluguel> getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		aluguel.setCliente(this);
		this.aluguel.add(aluguel);
	}
	public void remover(Aluguel al) {
		aluguel.remove(al);
	}

	@Override
	public String toString() {
		return "Cliente "+id+": "+nome+", Endereco: "+endereco+"\n";
	}
		
}
