package model.dao;

import java.util.List;

import model.domain.Aluguel;

public interface AluguelDao {

	List<Aluguel> getAlugueis(Aluguel aluguel);

	public void excluir(Aluguel aluguel);

	void atualizar(Aluguel aluguel);

	Aluguel salvar(Aluguel aluguel);

}