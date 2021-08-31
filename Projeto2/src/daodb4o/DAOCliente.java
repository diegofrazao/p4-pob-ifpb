package daodb4o;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;
import modelo.Cliente;

public class DAOCliente  extends DAO<Cliente>{
	public Cliente read (Object chave) {
		String cpf = (String) chave;
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("cpf").constrain(cpf);
		List<Cliente> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	public List<Cliente> consultarNumeroAlugueis(int n) {
		Query q = manager.query();
		q.constrain(Cliente.class);
		q.constrain(new Filtro(n));
		List<Cliente> result = q.execute();
		return result;
	}

	@SuppressWarnings("serial")
	class Filtro implements Evaluation {
		private int n;
		public Filtro(int n) { this.n = n; }	
		public void evaluate(Candidate candidate) {
			Cliente c = (Cliente) candidate.getObject();
			candidate.include(c.getAluguel().size() > n);
		}
	}
}