package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Aluguel;

public interface AluguelFacade {

	List<Aluguel> getAlugueis();

	List<Aluguel> getAlugueis(Integer codigo);

	@ValidateOnExecution
	Aluguel salvar(@Valid Aluguel aluguel);

	void atualizar(Aluguel aluguel);

	void deletarAluguel(Integer codigo);

}