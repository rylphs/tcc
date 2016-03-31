package ferreira.couto.raphael.formacaopv.domain.preco;

import static ferreira.couto.raphael.formacaopv.infra.utils.NumberUtils.toPrimitiveDouble;

import javax.faces.bean.CustomScoped;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import ferreira.couto.raphael.formacaopv.domain.comum.BaseEntity;
import ferreira.couto.raphael.formacaopv.domain.comum.Porcentagem;
import ferreira.couto.raphael.formacaopv.domain.comum.Real;

@Entity
public class Produto extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "custo"))                       
    })
	private Real custo = new Real(10);
	
	@Embedded 
	@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "lucro"))                       
    })
	private Porcentagem lucro;
	
	@Embedded 
	@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "comissao"))                       
    })
	private Porcentagem comissao;
	
	@Embedded 
	@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "imposto"))                       
    })
	private Porcentagem imposto;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "valor", column = @Column(name = "preco"))                       
    })
	private Real preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Real getCusto() {
		return custo;
	}

	public void setCusto(Real custo) {
		this.custo = custo;
	}

	public Porcentagem getLucro() {
		return lucro;
	}

	public void setLucro(Porcentagem lucro) {
		this.lucro = lucro;
	}

	public Porcentagem getComissao() {
		return comissao;
	}

	public void setComissao(Porcentagem comissao) {
		this.comissao = comissao;
	}

	public Porcentagem getDescontoImposto() {
		return imposto;
	}

	public void setDescontoImposto(Porcentagem descontoImposto) {
		this.imposto = descontoImposto;
	}

	public Real getPrecoFinal() {
		return preco;
	}

	public void setPrecoFinal(Real precoFinal) {
		this.preco = precoFinal;
	}

	public void atualizarPreco(Porcentagem percentualCustosFixos) {
		Porcentagem somatorio = Porcentagem.somatorio(
				imposto, comissao, lucro, percentualCustosFixos);
		this.preco = custo.dividirPor(somatorio.getValor());
	}
}
