package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Veiculo;

public class DAOVeiculo  extends DAO<Veiculo>{
	public Veiculo read (Object chave) {
		String placa = (String) chave;
		Query q = manager.query();
		q.constrain(Veiculo.class);
		q.descend("placa").constrain(placa);
		List<Veiculo> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}

