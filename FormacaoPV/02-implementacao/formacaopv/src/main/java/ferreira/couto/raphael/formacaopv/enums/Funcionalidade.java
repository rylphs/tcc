package ferreira.couto.raphael.formacaopv.enums;

public enum Funcionalidade {
	ADICAO_PRODUTO, ADICAO_MOVIMENTACAO;
	
	@Override
	public String toString(){
		return this.name().toLowerCase(); 
	}
}
