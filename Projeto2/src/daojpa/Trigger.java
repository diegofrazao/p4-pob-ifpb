package daojpa;

import java.time.LocalDate;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;

import modelo.Aluguel;

public class Trigger {
	
	@PrePersist
	public void exibirmsg1(Object obj) throws Exception {
//		System.out.println("@PrePersist => "+obj);
	}
	
	@PostLoad
	public void exibirmsg2(Object obj) throws Exception {
		if(obj instanceof Aluguel) {
			Aluguel a = (Aluguel)obj;
			LocalDate devolucao = calcularDevolucao(a);
			a.setDataDevolucao(devolucao);
		}
	}
	
	@PostPersist
	public void exibirmsg3(Object obj) {
		if (obj instanceof Aluguel)  {
			Aluguel a = (Aluguel)obj;
			LocalDate devolucao = calcularDevolucao(a);
			a.setDataDevolucao(devolucao);
		}
	}

	@PostRemove
	public void exibirmsg4(Object obj) {
//		System.out.println("@PostRemove => "+obj);
	}

	public LocalDate calcularDevolucao(Aluguel a) {
		LocalDate hoje = a.getDataAluguel();
		LocalDate devolucao = hoje.plusDays(15);
		return devolucao;
	}
}
