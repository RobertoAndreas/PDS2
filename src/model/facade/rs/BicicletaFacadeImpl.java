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

import model.dao.BicicletaDao;
import model.domain.Bicicleta;
import model.facade.BicicletaFacade;

@Path("/bicicleta")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class BicicletaFacadeImpl implements BicicletaFacade {

	@Inject
	private BicicletaDao bicicletaDao;

	@Override
	@GET
	public List<Bicicleta> getBicicletas() {
		return bicicletaDao.getBicicletas(new Bicicleta());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Bicicleta> getBicicletas(@PathParam("codigo") Integer codigo) {
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setCodigo(codigo);
		return bicicletaDao.getBicicletas(bicicleta);
	}

	@Override
	@POST
	public Bicicleta salvar(Bicicleta bicicleta) {
		bicicleta = bicicletaDao.salvar(bicicleta);
		return bicicleta;
	}

	@Override
	@PUT
	public void atualizar(Bicicleta bicicleta) {
		bicicletaDao.atualizar(bicicleta);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarBicicleta(@PathParam("codigo") Integer codigo) {
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setCodigo(codigo);
		bicicletaDao.excluir(bicicleta);
	}

}