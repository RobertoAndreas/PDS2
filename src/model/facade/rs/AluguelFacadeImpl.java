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

import model.dao.AluguelDao;
import model.domain.Aluguel;
import model.facade.AluguelFacade;

@Path("/aluguel")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AluguelFacadeImpl implements AluguelFacade {

	@Inject
	private AluguelDao aluguelDao;

	@Override
	@GET
	public List<Aluguel> getAlugueis() {
		return aluguelDao.getAlugueis(new Aluguel());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Aluguel> getAlugueis(@PathParam("codigo") Integer codigo) {
		Aluguel aluguel = new Aluguel();
		aluguel.setCodigo(codigo);
		return aluguelDao.getAlugueis(aluguel);
	}

	@Override
	@POST 
	public Aluguel salvar(Aluguel aluguel) { 
		aluguel = aluguelDao.salvar(aluguel);
	 	return aluguel;
	}

	@Override
	@PUT 
	public void atualizar(Aluguel aluguel) { 
		aluguelDao.atualizar(aluguel);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAluguel(@PathParam("codigo") Integer codigo) {
		Aluguel aluguel = new Aluguel();
		aluguel.setCodigo(codigo);
		aluguelDao.excluir(aluguel);
	}

}
