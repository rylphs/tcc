package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.annotation.PostConstruct;

import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

public abstract class TableEditMB<T> extends BaseMB {
	private enum Action{ EDIT, NEW}
	private T selecionado;
	private List<T> lista;
	private Action action;
	
	@PostConstruct
	public void onInit(){
		lista = getListaFromBC();
	}
	
	public void prepararAdicao(){
		action = Action.NEW;
		selecionado = createNew();
	}
	
	public void adicionar(){
		try {
			adicionarOnBC(selecionado);
			lista = getListaFromBC();
			info(getFuncionalidadeAdicao(),"sucesso");
		} catch (FormacaoPVException e) {
			error(e.getFeature(), e.getStatus());
		}
	}
	
	public boolean isEditando(){
		return action == Action.EDIT;
	}
	
	public T getSelecionado(){
		return selecionado;
	}
	
	public void setSelecionado(T selecionado){
		action = Action.EDIT;
		this.selecionado = selecionado;
	}
	
	public List<T> getLista(){
		return lista;
	}
	
	
	protected abstract List<T> getListaFromBC();
	protected abstract Funcionalidade getFuncionalidadeAdicao();
	protected abstract void adicionarOnBC(T selecionado) throws FormacaoPVException;
	protected abstract T createNew();
}
