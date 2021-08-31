package daomongodb;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Cliente;

public class DAOCliente extends DAO<Cliente>{
	
	public Cliente read (Object chave){
		try{
			String nome = (String) chave;
			TypedQuery<Cliente> c = manager.createQuery("select c from Cliente c where c.nome=:n", Cliente.class);
			c.setParameter("n", nome);
			return c.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Cliente> readAll() {
		TypedQuery<Cliente> c = manager.createQuery("select c from Cliente c order by c.nome", Cliente.class);
		return c.getResultList();
	}
	
	// CONSULTAS
	public  List<Cliente> consultarClientes(String caracteres) {
		TypedQuery<Cliente> c = manager.createQuery("select c from Cliente c where c.nome like '%"+caracteres+"%' order by c.nome", Cliente.class);
		return c.getResultList();
	}
	
	public  List<Cliente>  consultarClienteNAlugueis(int n) {
		TypedQuery<Cliente> q = manager.createQuery
				("select c from Cliente c where SIZE(c.aluguel) = :x", Cliente.class);
		q.setParameter("x", n);
		return q.getResultList(); 
	}
}