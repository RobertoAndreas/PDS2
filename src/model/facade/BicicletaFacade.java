package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Bicicleta;

public interface BicicletaFacade {

	List<Bicicleta> getBicicletas();

	List<Bicicleta> getBicicletas(Integer codigo);

	@ValidateOnExecution
	Bicicleta salvar(@Valid Bicicleta bicicleta);

	void atualizar(Bicicleta bicicleta);

	void deletarBicicleta(Integer codigo);

}