package Lista_Final;

import Array.Arreglo_string;

public class Usuario {

	String dni;
	Arreglo_string deportes;
	Usuario siguiente;
	
	public Usuario(String[] datos){
		this.dni = datos[0];
		deportes = cargarDeportes(datos);
		siguiente = null;
	}
	
	public Arreglo_string cargarDeportes(String[] datos){
		Arreglo_string aux = new Arreglo_string(5);
		for (int i = 1; i < datos.length; i++) {
			if(!(aux.existe(datos[i]) || datos[i].equals(""))){
				aux.agregar(datos[i]);
			}
		}
		return aux;
	}
	
	public String getDni(){
		return dni;
	}
	
	public void setSiguiente(Usuario Siguiente){
		this.siguiente = Siguiente;
	}
	
	public Usuario getSiguiente(){
		return siguiente;
	}
	
	public String imprimir(){
		String aux = dni;
		
		for (int i = 0; i < deportes.length(); i++) {
			aux += ";"+deportes.elemAt(i);
		}
	 return aux;	
	}
}
