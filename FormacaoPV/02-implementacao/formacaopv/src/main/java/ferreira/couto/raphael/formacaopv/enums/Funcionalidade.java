package ferreira.couto.raphael.formacaopv.enums;

public enum Funcionalidade {
	PRODUTO, MOVIMENTACAO, IMPOSTO;
	
	@Override
	public String toString(){
		return this.name().toLowerCase(); 
	}
}
