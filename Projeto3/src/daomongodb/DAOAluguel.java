package daomongodb;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Aluguel;
import modelo.Veiculo;

public class DAOAluguel extends DAO<Aluguel>{
	
	public Aluguel read(Object chave) {
		try {
			String id = (String) chave;
			TypedQuery<Aluguel> a = manager.createQuery("select a from Aluguel a where a.id = :id ", Aluguel.class);
			a.setParameter("i", id);
			return a.getSingleResult();
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
}