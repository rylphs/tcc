package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Imposto;
import ferreira.couto.raphael.formacaopv.persistence.ImpostoDAO;

public class ImpostoBC {
	@Inject ImpostoDAO impostoDAO;

	public List<Imposto> getImpostos() {
		return impostoDAO.findAll();
	}

	public void add(Imposto selecionado) {
		impostoDAO.add(selecionado);
	}

	public void update(Imposto selecionado) {
		impostoDAO.update(selecionado);
	}

	public void delete(Imposto selecionado) {
		impostoDAO.delete(selecionado);
	}

}
