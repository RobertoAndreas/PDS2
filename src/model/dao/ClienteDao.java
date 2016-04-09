package model.dao;

import java.util.List;

import model.domain.Cliente;

public interface ClienteDao {

	List<Cliente> getClientes(Cliente cliente);

	void excluir(Cliente cliente);

	void atualizar(Cliente cliente);

	Cliente salvar(Cliente cliente);

}