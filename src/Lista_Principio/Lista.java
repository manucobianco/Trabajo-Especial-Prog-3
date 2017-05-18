package Lista_Principio;

public class Lista {
	private int tamanio;
	private Usuario PunteroInicial;
	
	public Lista(){
		PunteroInicial=null;
		tamanio=0;	
	}
	
	public int size(){
		return this.tamanio; 
	}
	
	public boolean esVacia(){//retorna si es vacia o no!
		return this.size() == 0;
	}
	
	public Usuario getAt(int pos){
	    Usuario retorno;
	    Usuario actual = PunteroInicial;
	    
	    if(pos < size()){
	      for (int i = 0; i < pos; i++) {
	    	  actual = actual.getSiguiente();
	      }
	      retorno = actual;
	      return retorno;
	    }
	    return null;
	}
	
	public boolean existe(String dni){
		  Usuario userAux = PunteroInicial;
		  for (int i = 0; i < size(); i++) {
			  
		   if((userAux.getDni()).equals(dni)){
		    return true;
		    
		   }else{
		    userAux = userAux.getSiguiente();
		   }
		  }
		  return false;
		 }
		 
	public void agregarElemento(String[] datos){//agrega un elemento AL PRINCIPIO de la lista
		Usuario aux = new Usuario(datos);
		if(PunteroInicial!=null){				
			aux.setSiguiente(PunteroInicial);
		}
		PunteroInicial = aux;		
		this.tamanio++;
	}
	
	public void agregar(Usuario user){//agrega un elemento AL PRINCIPIO de la lista
	
		if(PunteroInicial!=null){				
			user.setSiguiente(PunteroInicial);
		}
		PunteroInicial = user;		
		this.tamanio++;
	}

}
