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

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Cliente {
	
	@Id		
	@GeneratedValue
	@Column(name="_id")
	private String id;
	
	private String nome;
	private String endereco;
	
	@OneToMany (mappedBy="cliente",
				cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
				orphanRemoval=true,
				fetch=FetchType.LAZY)
	private List<Aluguel> aluguel = new ArrayList<Aluguel>();
	
	
	// CONSTRUTOR
	public Cliente () {}
	
	public Cliente (String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	//GET & SET
	public String getId() {
		return id;
	}
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
