package Array;
public class Arreglo_usuarios {

  Usuario[] arreglo;
  int cantElem = 0;

  public Arreglo_usuarios(){
    arreglo = new Usuario[10000];
  }

  public Arreglo_usuarios(int tamanio){
    arreglo = new Usuario[tamanio];
  }

  public void agregar(Usuario elem){

    if (this.cantElem == arreglo.length){ //Si el arreglo esta lleno le duplicamos el tamaño
    	Usuario[] arregloNuevo = new Usuario[this.arreglo.length*2];
      for (int i = 0; i < arreglo.length; i++) {
        arregloNuevo[i] = this.arreglo[i];
      }
      this.arreglo = arregloNuevo;
    }
    arreglo[cantElem] = elem;
    cantElem++;
  }

  public void eliminarAt(int pos){
    //recordar excepcion de eliminar un null
    for (int i = pos; i < arreglo.length-1; i++) {
      arreglo[i] = arreglo[i+1];
    }
    this.cantElem--;
    arreglo[cantElem] = null;
  }

  public void insertarAt(int pos, Usuario elem){
    for (int i = this.arreglo.length-1; i > pos; i--) {
      this.arreglo[i] = this.arreglo[i-1];
    }
    this.arreglo[pos] = elem;
  }

  public int getCantElem(){
    return this.cantElem;
  }
  
  public int length(){
	  return cantElem;
  }
  
  public boolean existe(String dni){
	  
	  for (int i = 0; i < length(); i++) {
		  if(dni.equals(arreglo[i].getDni())){
			  return true;
		  }
	  }
	  return false;
  }

  public Usuario elemAt(int pos){
    return arreglo[pos];
  }

}