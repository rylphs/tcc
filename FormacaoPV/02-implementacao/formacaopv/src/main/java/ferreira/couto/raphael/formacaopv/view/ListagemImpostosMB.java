package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.ImpostoBC;
import ferreira.couto.raphael.formacaopv.entity.Imposto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;


@ManagedBean
@ViewScoped
public class ListagemImpostosMB extends TableEditMB<Imposto> {
	@Inject private ImpostoBC impostoBC;
	
	@Override
	protected List<Imposto> getListaFromBC() {
		return impostoBC.getImpostos();
	}

	@Override
	protected Funcionalidade getFuncionalidade() {
		return Funcionalidade.IMPOSTO;
	}

	@Override
	protected void adicionarOnBC(Imposto selecionado) throws FormacaoPVException {
		impostoBC.add(selecionado);
	}

	@Override
	protected void atualizarOnBC(Imposto selecionado) throws FormacaoPVException {
		impostoBC.update(selecionado);
	}

	@Override
	protected void removerOnBC(Imposto selecionado) throws FormacaoPVException {
		impostoBC.delete(selecionado);
	}

	@Override
	protected Imposto createNew() {
		return new Imposto();
	}
	
	@Override
	protected String getItemDescription(Imposto imposto) {
		return imposto.getNome();
	}

}
