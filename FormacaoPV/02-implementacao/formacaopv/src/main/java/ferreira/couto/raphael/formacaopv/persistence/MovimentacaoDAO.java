package ferreira.couto.raphael.formacaopv.persistence;

import ferreira.couto.raphael.formacaopv.entity.Movimentacao;

public class MovimentacaoDAO extends BaseDAO<Movimentacao> {

	public Double getCustosFixos() {
		String strQuery = "select avg(m.valor) from Movimentacao m where m.venda = false and m.produto is null";
		return qry(strQuery, Double.class).getSingleResult();
	}

	public Double getVendasMedias() {
		String strQuery = "select avg(m.valor) from Movimentacao m where m.venda = true";
		return qry(strQuery, Double.class).getSingleResult();
	}
}
