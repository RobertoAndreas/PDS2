package model.dao;

import java.util.List;

import model.domain.Bicicleta;

public interface BicicletaDao {

	List<Bicicleta> getBicicletas(Bicicleta bicicleta);

	void excluir(Bicicleta bicicleta);

	void atualizar(Bicicleta bicicleta);

	Bicicleta salvar(Bicicleta bicicleta);

}