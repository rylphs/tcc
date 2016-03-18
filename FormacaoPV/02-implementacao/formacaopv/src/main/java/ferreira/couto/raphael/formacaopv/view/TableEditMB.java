package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.annotation.PostConstruct;

import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

public abstract class TableEditMB<T> extends BaseMB {
	private enum Action{ EDIT, NEW}
	private T selecionado;
	private T editado;
	private List<T> lista;
	private Action action;
	
	@PostConstruct
	public void onInit(){
		lista = getListaFromBC();
	}
	
	public void prepararEdicao(){
		action = Action.EDIT;
		editado = selecionado;
	}
	
	public void prepararAdicao(){
		this.setSelecionado(null);
		action = Action.NEW;
		editado = createNew();
	}
	
	
	public void adicionar(){
		try {
			adicionarOnBC(editado);
			lista = getListaFromBC();
			info(getFuncionalidade(),"adicao.sucesso", getItemDescription(editado));
		} catch (FormacaoPVException e) {
			error(e.getFeature(), e.getStatus());
		}
	}
	
	public void atualizar(){
		try {
			atualizarOnBC(editado);
			lista = getListaFromBC();
			info(getFuncionalidade(),"edicao.sucesso", getItemDescription(editado));
		} catch (FormacaoPVException e) {
			error(e.getFeature(), e.getStatus());
		}
	}
	
	public void remover(){
		try {
			editado = selecionado;
			removerOnBC(editado);
			lista = getListaFromBC();
			info(getFuncionalidade(),"remocao.sucesso", getItemDescription(editado));
		}
		catch (FormacaoPVException e) {
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
		this.selecionado = selecionado;
	}
	
	public List<T> getLista(){
		return lista;
	}
	
	protected String getItemDescription(T item){
		return null;
	}
	
	public String getItemDescription(){
		if(selecionado==null) return null;
		return getItemDescription(selecionado);
	}
	
	public T getEditado() {
		return editado;
	}

	public void setEditado(T editado) {
		this.editado = editado;
	}
	
	protected abstract List<T> getListaFromBC();
	protected abstract Funcionalidade getFuncionalidade();
	protected abstract void adicionarOnBC(T selecionado) throws FormacaoPVException;
	protected abstract void atualizarOnBC(T selecionado) throws FormacaoPVException;
	protected abstract void removerOnBC(T selecionado) throws FormacaoPVException;
	protected abstract T createNew();
}
