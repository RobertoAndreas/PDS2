package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Aluguel;

public class AluguelDaoImpl implements AluguelDao {
	
	@PersistenceContext(unitName="SistemaAlugaBicicletaPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluguel> getAlugueis(Aluguel aluguel) {
		StringBuffer hql = new StringBuffer("from Aluguel c"
				+ " where 1 = 1");		
		if (aluguel.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (aluguel.getCodigo() != null) {
			query.setParameter("codigo",aluguel.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Aluguel aluguel) {
		aluguel = entityManager.merge(aluguel);
		entityManager.remove(aluguel);
	}

	@Override
	@Transactional
	public Aluguel salvar(Aluguel aluguel) {
		entityManager.persist(aluguel);
		return aluguel;
	}

	@Override
	@Transactional
	public void atualizar(Aluguel aluguel) {
		aluguel = entityManager.merge(aluguel);
		entityManager.persist(aluguel);		
	}
	

}
