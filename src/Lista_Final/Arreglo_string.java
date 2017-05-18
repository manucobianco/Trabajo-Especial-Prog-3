package Lista_Final;

public class Arreglo_string {

  String[] arreglo;
  int cantElem = 0;

  public Arreglo_string(){
    arreglo = new String[10000];
  }

  public Arreglo_string(int tamanio){
    arreglo = new String[tamanio];
  }

  public void agregar(String elem){

    if (this.cantElem == arreglo.length){ //Si el arreglo esta lleno le duplicamos el tamaño
      String[] arregloNuevo = new String[this.arreglo.length*2];
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

  public void insertarAt(int pos, String elem){
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
  
  public boolean existe(String aux){
	  
	  for (int i = 0; i < length(); i++) {
		  if(aux.equals(arreglo[i])){
			  return true;
		  }
	  }
	  return false;
  }

  public String elemAt(int pos){
    return arreglo[pos];
  }

  public String toString(){
    String retorno="";
    for (int i = 0; i < arreglo.length; i++) {
      retorno += "["+this.arreglo[i]+"]";
    }
    return retorno;
  }
}