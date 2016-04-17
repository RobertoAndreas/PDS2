package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Bicicleta;

public class BicicletaDaoImpl implements BicicletaDao {

	@PersistenceContext(unitName = "SistemaAlugaBicicletaPU")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Bicicleta> getBicicletas(Bicicleta bicicleta) {
		StringBuffer hq1 = new StringBuffer("from Bicicleta c where 1 = 1");
		if (bicicleta.getCodigo() != null) {
			hq1.append(" and c.codigo = :codigo");
		}

		Query query = entityManager.createQuery(hq1.toString());
		if (bicicleta.getCodigo() != null) {
			query.setParameter("codigo", bicicleta.getCodigo());
		}
		return query.getResultList();

	}

	@Override
	@Transactional
	public void excluir(Bicicleta bicicleta) {
		bicicleta = entityManager.merge(bicicleta);
		entityManager.remove(bicicleta);
	}

	@Override
	@Transactional
	public Bicicleta salvar(Bicicleta bicicleta) {
		entityManager.persist(bicicleta);
		return bicicleta;
	}

	@Override
	@Transactional
	public void atualizar(Bicicleta bicicleta) {
		bicicleta = entityManager.merge(bicicleta);
		entityManager.persist(bicicleta);

	}

}
