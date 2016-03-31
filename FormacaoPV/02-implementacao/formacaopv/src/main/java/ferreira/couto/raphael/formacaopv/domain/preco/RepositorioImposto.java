package ferreira.couto.raphael.formacaopv.domain.preco;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.infra.preco.ImpostoDAO;

public class RepositorioImposto {
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
