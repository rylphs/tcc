package ferreira.couto.raphael.formacaopv.domain.comum;

public enum Funcionalidade {
	PRODUTO, MOVIMENTACAO, IMPOSTO, ESTOQUE;
	
	@Override
	public String toString(){
		return this.name().toLowerCase(); 
	}
}
