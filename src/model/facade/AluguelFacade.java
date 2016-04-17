package model.facade;

import java.util.List;

import model.domain.Aluguel;

public interface AluguelFacade {

	List<Aluguel> getAlugueis();

	List<Aluguel> getAlugueis(Integer codigo);

	Aluguel salvar(Aluguel aluguel);

	void atualizar(Aluguel aluguel);

	void deletarAluguel(Integer codigo);

}