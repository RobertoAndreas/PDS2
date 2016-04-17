package model.facade;

import java.util.List;

import model.domain.Bicicleta;

public interface BicicletaFacade {

	List<Bicicleta> getBicicletas();

	List<Bicicleta> getBicicletas(Integer codigo);

	Bicicleta salvar(Bicicleta bicicleta);

	void atualizar(Bicicleta bicicleta);

	void deletarBicicleta(Integer codigo);

}