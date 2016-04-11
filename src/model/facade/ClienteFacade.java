package model.facade;

import java.util.List;

import model.domain.Cliente;

public interface ClienteFacade {

	List<Cliente> getClientes(Integer codigo);

	Cliente salvar(Cliente cliente);

	void atualizar(Cliente cliente);

	List<Cliente> getClientes();

	void deletarCliente(Integer codigo);


}