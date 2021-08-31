package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Aluguel;

public class DAOAluguel extends DAO<Aluguel>{
	
	public Aluguel read(Object chave) {
		try {
			String placa = (String) chave;
			TypedQuery<Aluguel> q = manager.createQuery("select a from Aluguel a where a.veiculo.placa = :p ", Aluguel.class);
			q.setParameter("p", placa);
			return q.getSingleResult();
		}catch(NoResultException e) {
			return null;			
		}
	}
	
	public List<Aluguel> readAll() {
		TypedQuery<Aluguel> a = manager.createQuery("select a from Aluguel a order by a.id", Aluguel.class);
		return a.getResultList();
	}
	
	// CONSULTAS
	public List<Aluguel> consultarAlugueis(String caracteres) {
		TypedQuery<Aluguel> a = manager.createQuery("select a from Aluguel a where a.veiculo.placa like '%"+caracteres+"%' order by a.veiculo.placa", Aluguel.class);
		return a.getResultList();
	}

	public List<Aluguel> clientesAlugueis(String caracteres, Object modelo){
		String mod = (String) modelo;
		TypedQuery<Aluguel> q = manager.createQuery("select a from Aluguel a JOIN a.cliente c JOIN a.veiculo v where c.nome like '"+caracteres+"' or v.modelo = :modelo ", Aluguel.class);
		q.setParameter("modelo", mod);
		return q.getResultList();
	}

}
