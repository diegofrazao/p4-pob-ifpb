package dao;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Aluguel;
import modelo.Veiculo;




public class DAOAluguel  extends DAO<Aluguel>{
	public Aluguel read (Object chave) {		
		String placa = (String) chave;
		Query q = manager.query();
		q.constrain(Aluguel.class);
		q.descend("veiculo").descend("placa").constrain(placa);
		List<Aluguel> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public  Aluguel consultarVeiculoAluguel(Object chave) {
		String placa = (String) chave;
		Query q = manager.query();
		q.constrain(Aluguel.class);
		q.descend("veiculo").descend("placa").constrain(placa).like();
		List<Aluguel> result = q.execute();
		if (result.size()>0)
			return result.get(0);
		else
			return null;
	}
	
	public List<Aluguel> testeDisp (Object chave) {
		String placa = (String) chave;
		Query q = manager.query();
		q.constrain(Aluguel.class);
		q.descend("veiculo").descend("placa").constrain(placa).like();
		List<Aluguel> result = q.execute();
		return result;
	}
}

@SuppressWarnings("serial")
//livros cujos autores nao possuem outro livro
class Filtro1 implements Evaluation {
	public void evaluate(Candidate candidate) {
		Veiculo v = (Veiculo) candidate.getObject();
		boolean filtro = true;
		for(Aluguel a : v.getAluguel())
			if(a.getVeiculo()!=null)
				filtro=false;
		
		candidate.include(filtro);
	}
}