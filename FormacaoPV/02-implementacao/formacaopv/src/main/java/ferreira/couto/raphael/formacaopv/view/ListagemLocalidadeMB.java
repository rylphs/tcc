package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.EstoqueBC;
import ferreira.couto.raphael.formacaopv.entity.Localidade;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

@ManagedBean
@ViewScoped
public class ListagemLocalidadeMB extends TableEditMB<Localidade> {
	@Inject EstoqueBC estoqueBC;

	@Override
	protected List<Localidade> getListaFromBC() {
		return estoqueBC.getLocalidades();
	}

	@Override
	protected Funcionalidade getFuncionalidade() {
		return Funcionalidade.ESTOQUE;
	}

	@Override
	protected void adicionarOnBC(Localidade localidade) throws FormacaoPVException {
		estoqueBC.add(localidade);
	}

	@Override
	protected void atualizarOnBC(Localidade localidade) throws FormacaoPVException {
		estoqueBC.update(localidade);
	}

	@Override
	protected void removerOnBC(Localidade localidade) throws FormacaoPVException {
		estoqueBC.delete(localidade);
	}

	@Override
	protected Localidade createNew() {
		return new Localidade();
	}

	@Override
	protected String getItemDescription(Localidade localidade) {
		return "Localidade \""+localidade.getNome()+ "\"";
	}

}
