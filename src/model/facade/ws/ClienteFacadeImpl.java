package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.ClienteDao;
import model.domain.Cliente;
import model.facade.ClienteFacade;

@WebService(serviceName = "ws/cliente")
public class ClienteFacadeImpl implements ClienteFacade {

	@Inject
	private ClienteDao clienteDao;
//a
	
	@WebMethod
	public List<Cliente> getClientes() {
		return clienteDao.getClientes(new Cliente());
	}

	@WebMethod(operationName = "getClienteCodigo")
	public List<Cliente> getClientes(Integer codigo) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		return clienteDao.getClientes(cliente);
	}

	@WebMethod
	public Cliente salvar(Cliente cliente){
		return clienteDao.salvar(cliente);
	}

	@WebMethod
	public void atualizar(Cliente cliente) {
		clienteDao.atualizar(cliente);
	}
	
	@WebMethod
	public void deletarCliente(Integer codigo){
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigo);
		clienteDao.excluir(cliente);
	}

}