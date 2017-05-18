package Lista_Final;

public class Lista {
	private int tamanio;
	private Usuario inicial, ultimo;
	
	public Lista(){
		inicial=null;
		ultimo =null;  // Se guarda el ultimo, para que en la carga de los datos no tenga que recorrer todos.
		tamanio=0;	
	}
	
	public int size(){  // -> tamanio
		return this.tamanio; 
	}
	
	public boolean esVacia(){   
		return size() == 0;
	}
	
	public Usuario getAt(int pos){
	    Usuario retorno;
	    Usuario actual = inicial;
	    
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
		  Usuario userAux = inicial;
		  for (int i = 0; i < size(); i++) {
			  
		   if((userAux.getDni()).equals(dni)){
		    return true;
		    
		   }else{
		    userAux = userAux.getSiguiente();
		   }
		  }
		  return false;
		 }
	
	public void agregarElemento(String[] datos){//agrega un elemento AL FINAL de la lista
		Usuario guardar = new Usuario(datos);
		
		if(inicial == null){
			inicial = guardar;
		}else {
			ultimo.setSiguiente(guardar);
		}		
		tamanio++;
	}

	public void agregar(Usuario user) { // agrega un usuario AL FINAL de la lista
		
		if(inicial == null){
			inicial = user;
			ultimo  = user;
		}else{
			ultimo.setSiguiente(user);
			ultimo = user;
		}		
		tamanio++;
	}
}