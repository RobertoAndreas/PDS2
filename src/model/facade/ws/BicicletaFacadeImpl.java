package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.BicicletaDao;
import model.domain.Bicicleta;
import model.facade.BicicletaFacade;

@WebService(serviceName = "ws/bicicleta")
public class BicicletaFacadeImpl implements BicicletaFacade {

	@Inject
	private BicicletaDao bicicletaDao;
	
	@WebMethod
	public List<Bicicleta> getBicicletas() {
		return bicicletaDao.getBicicletas(new Bicicleta());
	}

	@WebMethod(operationName = "getBicicletaCodigo")
	public List<Bicicleta> getBicicletas(Integer codigo) {
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setCodigo(codigo);
		return bicicletaDao.getBicicletas(bicicleta);
	}

	@WebMethod
	public Bicicleta salvar(@WebParam(name="bicicleta") Bicicleta bicicleta){
		return bicicletaDao.salvar(bicicleta);
	}

	@WebMethod
	public void atualizar(@WebParam(name="bicicleta") Bicicleta bicicleta) {
		bicicletaDao.atualizar(bicicleta);
	}
	
	@WebMethod
	public void deletarBicicleta(@WebParam(name="codigoBicicleta") Integer codigo){
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setCodigo(codigo);
		bicicletaDao.excluir(bicicleta);
	}

}