package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.domain.comum.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.domain.comum.Funcionalidade;
import ferreira.couto.raphael.formacaopv.domain.preco.Imposto;
import ferreira.couto.raphael.formacaopv.domain.preco.RepositorioImposto;


@ManagedBean
@ViewScoped
public class ListagemImpostosMB extends TableEditMB<Imposto> {
	@Inject private RepositorioImposto impostoBC;
	
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
		return "Imposto \""+imposto.getNome()+"\"";
	}

}
