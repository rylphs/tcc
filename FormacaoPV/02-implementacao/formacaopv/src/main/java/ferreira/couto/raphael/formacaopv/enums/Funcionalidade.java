package ferreira.couto.raphael.formacaopv.enums;

public enum Funcionalidade {
	PRODUTO, MOVIMENTACAO;
	
	@Override
	public String toString(){
		return this.name().toLowerCase(); 
	}
}
