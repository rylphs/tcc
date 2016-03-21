package ferreira.couto.raphael.formacaopv.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.ImpostoBC;
import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Imposto;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.ProdutorEntityManager;

@ViewScoped
@ManagedBean
public class ListagemProdutoMB extends TableEditMB<Produto> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject private ProdutoBC produtoBC;
	@Inject private ImpostoBC impostoBC;
	
	private Imposto impostoSelecionado;
	private List<Imposto> impostos = new ArrayList<>();
	private List<Imposto> impostosSelecionados = new ArrayList<>();

	@Override
	protected void onInit(){
		impostos = impostoBC.getImpostos();
	}
	
	@Override
	protected void beforeAdd(Produto adicionado){
		for(Imposto imposto : impostosSelecionados){
			produtoBC.adicionarImposto(adicionado, imposto);
		}
	}
	
	@Override
	protected List<Produto> getListaFromBC() {
		return produtoBC.getProdutos();
	}

	@Override
	protected Funcionalidade getFuncionalidade() {
		return Funcionalidade.PRODUTO;
	}

	@Override
	protected void adicionarOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.addProduto(selecionado);
	}
	
	@Override
	protected void atualizarOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.updateProduto(selecionado);
	}
	
	@Override
	protected void removerOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.deleteProduto(selecionado);
	}

	@Override
	protected Produto createNew() {
		return new Produto();
	}
	
	@Override
	protected String getItemDescription(Produto produto){
		return "Produto \"" +produto.getNome() + "\"";
	}
	
	public List<Imposto> getImpostos(){
		return impostos;
	}

	public Imposto getImpostoSelecionado() {
		return impostoSelecionado;
	}

	public void setImpostoSelecionado(Imposto impostoSelecionado) {
		this.impostoSelecionado = impostoSelecionado;
	}

	public List<Imposto> getImpostosSelecionados() {
		return impostosSelecionados;
	}

	public void setImpostosSelecionados(List<Imposto> impostosSelecionados) {
		this.impostosSelecionados = impostosSelecionados;
	}
	
}
