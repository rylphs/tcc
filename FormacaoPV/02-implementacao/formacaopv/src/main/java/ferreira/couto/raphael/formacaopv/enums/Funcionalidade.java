package ferreira.couto.raphael.formacaopv.enums;

public enum Funcionalidade {
	PRODUTO, MOVIMENTACAO, IMPOSTO, ESTOQUE;
	
	@Override
	public String toString(){
		return this.name().toLowerCase(); 
	}
}
