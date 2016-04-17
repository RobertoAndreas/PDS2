package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AluguelDao;
import model.domain.Aluguel;
import model.facade.AluguelFacade;

@WebService(serviceName="ws/aluguel")
public class AluguelFacadeImpl implements AluguelFacade {
	
	@Inject
	private AluguelDao aluguelDao;
			
	@WebMethod
	public List<Aluguel> getAlugueis() {
		return aluguelDao.getAlugueis(new Aluguel());
	}
	
	@Override
	@WebMethod(operationName="getAluguelCodigo")
	public List<Aluguel> getAlugueis(@WebParam(name="codigoAluguel") 
							Integer codigo) {
		Aluguel aluguel = new Aluguel();
		aluguel.setCodigo(codigo);
		return aluguelDao.getAlugueis(aluguel);
	}
	
	@WebMethod
	public Aluguel salvar(@WebParam(name="aluguel") Aluguel aluguel) {
		return aluguelDao.salvar(aluguel);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="aluguel") Aluguel aluguel) {
		aluguelDao.atualizar(aluguel);
	}
	
	@WebMethod
	public void deletarAluguel(@WebParam(name="codigoAluguel") Integer codigo) {
		Aluguel aluguel = new Aluguel();
		aluguel.setCodigo(codigo);
		aluguelDao.excluir(aluguel);
	}


}
