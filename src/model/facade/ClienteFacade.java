package model.facade;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import model.domain.Cliente;

public interface ClienteFacade {

	List<Cliente> getClientes(Integer codigo);

	Cliente salvar(Cliente cliente);

	void atualizar(Cliente cliente);

	List<Cliente> getClientes();

	void deletarCliente(Integer codigo);


}