package ferreira.couto.raphael.formacaopv.enums;

public enum Funcionalidade {
	ADICAO_PRODUTO;
	
	@Override
	public String toString(){
		return this.name().toLowerCase(); 
	}
}
