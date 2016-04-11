package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.ClienteDao;
import model.domain.Cliente;
import model.facade.ClienteFacade;

@Path("/cliente")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ClienteFacadeImpl implements ClienteFacade {

	@Inject
	private ClienteDao clienteDao;

	@Override
	@GET
	@Path("/{codigo}")
	public List<Cliente> getClientes(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		return clienteDao.getClientes(cliente);
	}
	
	@Override
	@POST
	public Cliente salvar(Cliente cliente) {
		cliente = clienteDao.salvar(cliente);
		return cliente;
	}

	@Override
	@PUT
	public void atualizar(Cliente cliente){
		clienteDao.atualizar(cliente);
	}

	@Override
	@GET
	public List<Cliente> getClientes() {
		return clienteDao.getClientes(new Cliente());
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarCliente(@PathParam("codigo") Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		clienteDao.excluir(cliente);
	}

}