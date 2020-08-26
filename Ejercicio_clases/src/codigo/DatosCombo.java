package codigo;

public class DatosCombo<T> {
    
    
	private String id;
	private T valor;
	
	
	public DatosCombo(){

		
	}
	
	
	public DatosCombo(String id,T valor){
		this.id=id;
		this.valor=valor;
		
	}

	/**
	 * @return the id
	 */
	@Override
	public String toString() {
		return id;
	}


	/**
	 * @return the valor
	 */
	public T getValor() {
		return valor;
	}

	public String getId(){
		return id;
	}
	
	public void setValor(T valor){
		this.valor=valor;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
    
}
