package daomongodb;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Veiculo;

public class DAOVeiculo extends DAO<Veiculo>{
	
	public Veiculo read (Object chave){
		try{
			String placa = (String) chave;
			TypedQuery<Veiculo> q = manager.createQuery("select v from Veiculo v where v.placa=:v", Veiculo.class);
			q.setParameter("v", placa);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	public List<Veiculo> readAll() {
		TypedQuery<Veiculo> v = manager.createQuery("select v from Veiculo v order by v.id", Veiculo.class);
		return v.getResultList();
	}
	
	// CONSULTAS
	public  List<Veiculo> consultarVeiculos(String caracteres) {
		TypedQuery<Veiculo> v = manager.createQuery("select v from Veiculo v where v.placa like '%"+caracteres+"%' order by v.placa", Veiculo.class);
		return v.getResultList();
	}
}